
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClassType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Animal"/>
 *     &lt;enumeration value="Face"/>
 *     &lt;enumeration value="Human"/>
 *     &lt;enumeration value="Vehical"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClassType")
@XmlEnum
public enum ClassType {

    @XmlEnumValue("Animal")
    ANIMAL("Animal"),
    @XmlEnumValue("Face")
    FACE("Face"),
    @XmlEnumValue("Human")
    HUMAN("Human"),
    @XmlEnumValue("Vehical")
    VEHICAL("Vehical"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    ClassType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClassType fromValue(String v) {
        for (ClassType c: ClassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
