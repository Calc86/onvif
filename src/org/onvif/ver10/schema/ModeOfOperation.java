
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModeOfOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ModeOfOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Idle"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ModeOfOperation")
@XmlEnum
public enum ModeOfOperation {

    @XmlEnumValue("Idle")
    IDLE("Idle"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),

    /**
     * This case should never happen.
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    ModeOfOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModeOfOperation fromValue(String v) {
        for (ModeOfOperation c: ModeOfOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
