package com.onvif;

//import javax.xml.bind.JAXBContext;
import javax.xml.bind.*;
import java.io.StringWriter;

/**
 * Created by calc on 10.07.14.
 *
 */
public class Query {
    private static final String PLACEHOLDER = "{FRAGMENT}";

    public String getXML(Object object){
        try {
            //JAXBContext jc = JAXBContext.newInstance(object.getClass());
            javax.xml.bind.JAXBContext jc = JAXBContext.getInstance();

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            StringWriter fragment = new StringWriter();
            //marshaller.marshal(getCapabilities, System.out);
            marshaller.marshal(object, fragment);

            String template = "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\">"
                    + "<s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"
                    + PLACEHOLDER
                    + "</s:Body></s:Envelope>";

            return template.replace(PLACEHOLDER, fragment.toString());

            //System.out.println(xml);
            //return xml;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
