package com.onvif;

import org.w3._2003._05.soap_envelope.Body;
import org.w3._2003._05.soap_envelope.Envelope;
import org.w3._2003._05.soap_envelope.Header;

import javax.xml.bind.*;
import java.io.StringWriter;

/**
 * Created by calc on 10.07.14.
 *
 */
public class Query {
    public String getXML(Object request, Header header){
        javax.xml.bind.JAXBContext jc = JAXBContext.getInstance();

        if(jc == null)
            throw new IllegalStateException("need to launch onvif JAXBContext.create()");
        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            StringWriter xml = new StringWriter();
            //marshaller.marshal(getCapabilities, System.out);
            Envelope envelope = new Envelope();
            if(request != null){
                Body body = new Body();
                body.getAny().add(request);
                envelope.setBody(body);
            }

            if(header != null){
                envelope.setHeader(header);
            }

            marshaller.marshal(envelope, xml);

            return xml.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
