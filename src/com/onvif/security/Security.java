package com.onvif.security;

import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.AttributedString;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.SecurityHeaderType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.UsernameTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.onvif.ver10.schema.DateTime;
import org.w3._2003._05.soap_envelope.Header;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.security.NoSuchAlgorithmException;

/**
 * Created by calc on 08.08.14.
 *
 */
public class Security {
    private String timestamp;
    private String user;
    private String password;
    private String nonce;

    public Security(DateTime dateTime, String user, String password, String nonce) {
        timestamp = getOnvifTimeStamp(dateTime);
        this.user = user;
        this.password = password;
        this.nonce = nonce;
    }

    public static String getOnvifTimeStamp(DateTime dateTime){
        return String.format("%4d-%02d-%02dT%02d:%02d:%02d.000Z",
                dateTime.getDate().getYear(),
                dateTime.getDate().getMonth(),
                dateTime.getDate().getDay(),
                dateTime.getTime().getHour(),
                dateTime.getTime().getMinute(),
                dateTime.getTime().getSecond()
        );
    }

    /**
     * Password_Digest = Base64 ( SHA-1 ( nonce + created + password ) )
     * @return base64
     */
    public String getPasswordDigest(){
        //Password_Digest = Base64 ( SHA-1 ( nonce + created + password ) )
        String line = getNonce() + timestamp + password;
        try {
            line = base64(sha1(line.getBytes()));
            return line;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getNonce(){
        return nonce;
    }

    public String getNonceDigest(){
        return base64(getNonce().getBytes());
    }

    public String base64(byte[] data){
        return DatatypeConverter.printBase64Binary(data);
    }

    public byte[] sha1(byte[] digest) throws NoSuchAlgorithmException {
        java.security.MessageDigest d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(digest);
        return d.digest();
    }

    public Header buildHeader(){

        Header header = new Header();

        SecurityHeaderType security = new SecurityHeaderType();
        JAXBElement<SecurityHeaderType> securityXml
                = new JAXBElement<>(new QName("Security"), SecurityHeaderType.class, security);
        security.getOtherAttributes().put(new QName("http://www.w3.org/2003/05/soap-envelope", "mustUnderstand"), "1");
        security.getOtherAttributes().put(new QName("xmlns"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

        UsernameTokenType usernameToken = new UsernameTokenType();
        JAXBElement<UsernameTokenType> usernameTokenXml
                = new JAXBElement<>(new QName("UsernameToken"), UsernameTokenType.class, usernameToken);

        AttributedString username = new AttributedString();
        JAXBElement<AttributedString> usernameXml
                = new JAXBElement<>(new QName("Username"), AttributedString.class, username);
        username.setValue(this.user);

        AttributedString password = new AttributedString();
        JAXBElement<AttributedString> passwordXml
                = new JAXBElement<>(new QName("Password"), AttributedString.class, password);
        password.getOtherAttributes().put(new QName("Type"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest");
        password.setValue(getPasswordDigest());

        AttributedString nonce = new AttributedString();
        JAXBElement<AttributedString> nonceXml
                = new JAXBElement<>(new QName("Nonce"), AttributedString.class, nonce);
        nonce.getOtherAttributes().put(new QName("EncodingType"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
        nonce.setValue(getNonceDigest());

        AttributedDateTime created = new AttributedDateTime();
        JAXBElement<AttributedDateTime> createdXml
                = new JAXBElement<>(new QName("Created"), AttributedDateTime.class, created);
        created.getOtherAttributes().put(new QName("xmlns"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        created.setValue(timestamp);

        usernameToken.getAny().add(usernameXml);
        usernameToken.getAny().add(passwordXml);
        usernameToken.getAny().add(nonceXml);
        usernameToken.getAny().add(createdXml);
        security.getAny().add(usernameTokenXml);

        header.getAny().add(securityXml);
        return header;
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Security s:mustUnderstand=\"1\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">");
            sb.append("<UsernameToken>");
                sb.append("<Username>");
                    sb.append(user);
                sb.append("</Username>");
                sb.append("<Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest\">");
                    sb.append(getPasswordDigest(password, timestamp));
                sb.append("</Password>");
                sb.append("<Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">");
                sb.append(base64(nonce.getBytes()));
                sb.append("</Nonce>");
                sb.append("<Created xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">");
                sb.append(timestamp);
                sb.append("</Created>");
            sb.append("</UsernameToken>");
        sb.append("</Security>");
        return sb.toString();
    }*/
}
