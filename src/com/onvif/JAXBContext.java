package com.onvif;

import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.SecurityHeaderType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.UsernameTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.onvif.ver10.device.wsdl.GetCapabilities;
import org.onvif.ver10.device.wsdl.GetCapabilitiesResponse;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTime;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTimeResponse;
import org.onvif.ver10.media.wsdl.*;
import org.w3._2003._05.soap_envelope.Body;
import org.w3._2003._05.soap_envelope.Envelope;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

/**
 * Created by calc on 11.07.14.
 *
 */
public class JAXBContext {
    private static javax.xml.bind.JAXBContext instance = null;

    public static javax.xml.bind.JAXBContext getInstance() {
        return instance;
    }

    public static void create() throws JAXBException {
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(Envelope.class);
        classes.add(org.xmlsoap.schemas.soap.envelope.Envelope.class);
        classes.add(Body.class);

        //Тут указываем требуемые нам классы во время работы нашей штуки
        classes.add(GetCapabilities.class);
        classes.add(GetCapabilitiesResponse.class);
        classes.add(GetProfiles.class);
        classes.add(GetProfilesResponse.class);
        classes.add(GetStreamUri.class);
        classes.add(GetStreamUriResponse.class);
        classes.add(GetSnapshotUri.class);
        classes.add(GetSnapshotUriResponse.class);

        classes.add(GetSystemDateAndTime.class);
        classes.add(GetSystemDateAndTimeResponse.class);

        classes.add(SecurityHeaderType.class);
        classes.add(UsernameTokenType.class);
        classes.add(AttributedDateTime.class);

        instance = javax.xml.bind.JAXBContext.newInstance(classes.toArray(new Class[0]));
    }
}
