
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IPv6DHCPConfiguration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IPv6DHCPConfiguration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Auto"/>
 *     &lt;enumeration value="Stateful"/>
 *     &lt;enumeration value="Stateless"/>
 *     &lt;enumeration value="Off"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IPv6DHCPConfiguration")
@XmlEnum
public enum IPv6DHCPConfiguration {

    @XmlEnumValue("Auto")
    AUTO("Auto"),
    @XmlEnumValue("Stateful")
    STATEFUL("Stateful"),
    @XmlEnumValue("Stateless")
    STATELESS("Stateless"),
    @XmlEnumValue("Off")
    OFF("Off");
    private final String value;

    IPv6DHCPConfiguration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IPv6DHCPConfiguration fromValue(String v) {
        for (IPv6DHCPConfiguration c: IPv6DHCPConfiguration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
