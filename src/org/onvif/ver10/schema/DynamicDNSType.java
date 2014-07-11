
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicDNSType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DynamicDNSType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoUpdate"/>
 *     &lt;enumeration value="ClientUpdates"/>
 *     &lt;enumeration value="ServerUpdates"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DynamicDNSType")
@XmlEnum
public enum DynamicDNSType {

    @XmlEnumValue("NoUpdate")
    NO_UPDATE("NoUpdate"),
    @XmlEnumValue("ClientUpdates")
    CLIENT_UPDATES("ClientUpdates"),
    @XmlEnumValue("ServerUpdates")
    SERVER_UPDATES("ServerUpdates");
    private final String value;

    DynamicDNSType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DynamicDNSType fromValue(String v) {
        for (DynamicDNSType c: DynamicDNSType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
