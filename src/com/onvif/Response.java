package com.onvif;


import org.w3._2003._05.soap_envelope.Body;
import org.w3._2003._05.soap_envelope.Envelope;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

/**
 * Created by calc on 10.07.14.
 *
 */
public class Response<E> {
    public E getResponse(String xml){
        if(xml.equals("")) return null;

        try {
            javax.xml.bind.JAXBContext jc = com.onvif.JAXBContext.getInstance();

            Unmarshaller u = jc.createUnmarshaller();

            Source s = new StreamSource(new StringReader(xml));
            JAXBElement root = (JAXBElement)u.unmarshal(s);

            if(root.getValue().getClass().toString().equals("class org.xmlsoap.schemas.soap.envelope.Envelope")){
                //SOAP 1.1
                org.xmlsoap.schemas.soap.envelope.Envelope e = (org.xmlsoap.schemas.soap.envelope.Envelope)root.getValue();
                return (E) e.getBody().getAny().get(0);
            }
            else{
                //SOAP 1.2
                Envelope e = (Envelope)root.getValue();
                return (E) e.getBody().getAny().get(0);
            }

        } catch (JAXBException e) {
            e.printStackTrace();

            return null;
        }
    }
}
