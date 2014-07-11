
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransportProtocol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransportProtocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UDP"/>
 *     &lt;enumeration value="TCP"/>
 *     &lt;enumeration value="RTSP"/>
 *     &lt;enumeration value="HTTP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransportProtocol")
@XmlEnum
public enum TransportProtocol {

    UDP,
    TCP,
    RTSP,
    HTTP;

    public String value() {
        return name();
    }

    public static TransportProtocol fromValue(String v) {
        return valueOf(v);
    }

}
