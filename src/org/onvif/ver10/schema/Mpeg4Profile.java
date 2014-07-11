
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Mpeg4Profile.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Mpeg4Profile">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="ASP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Mpeg4Profile")
@XmlEnum
public enum Mpeg4Profile {

    SP,
    ASP;

    public String value() {
        return name();
    }

    public static Mpeg4Profile fromValue(String v) {
        return valueOf(v);
    }

}
