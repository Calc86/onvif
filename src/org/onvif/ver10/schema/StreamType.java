
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StreamType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StreamType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RTP-Unicast"/>
 *     &lt;enumeration value="RTP-Multicast"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StreamType")
@XmlEnum
public enum StreamType {

    @XmlEnumValue("RTP-Unicast")
    RTP_UNICAST("RTP-Unicast"),
    @XmlEnumValue("RTP-Multicast")
    RTP_MULTICAST("RTP-Multicast");
    private final String value;

    StreamType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StreamType fromValue(String v) {
        for (StreamType c: StreamType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
