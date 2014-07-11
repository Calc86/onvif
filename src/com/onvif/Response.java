package com.onvif;


import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.onvif.ver10.device.wsdl.GetCapabilitiesResponse;
import org.w3._2003._05.soap_envelope.Body;
import org.w3._2003._05.soap_envelope.Envelope;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by calc on 10.07.14.
 *
 */
public class Response<E> {
    //Class<E> type;
    private Class type;

    /**
     *
     * @param type Class Class of object (Object.class, object.getClass())
     */
    public Response(Class type) {
        this.type = type;
    }

    public E getResponse(String xml){
        try {
            JAXBContext jc  = JAXBContext.newInstance(Envelope.class, type);
            Unmarshaller u = jc.createUnmarshaller();

            Source s = new StreamSource(new StringReader(xml));
            JAXBElement<Envelope> root = u.unmarshal(s, Envelope.class);
            Envelope e = root.getValue();
            return (E) e.getBody().getAny().get(0);

        } catch (JAXBException e) {
            e.printStackTrace();

            return null;
        }
    }
}
