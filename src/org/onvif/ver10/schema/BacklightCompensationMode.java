
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BacklightCompensationMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BacklightCompensationMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OFF"/>
 *     &lt;enumeration value="ON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BacklightCompensationMode")
@XmlEnum
public enum BacklightCompensationMode {


    /**
     * Backlight compensation is disabled.
     * 
     */
    OFF,

    /**
     * Backlight compensation is enabled.
     * 
     */
    ON;

    public String value() {
        return name();
    }

    public static BacklightCompensationMode fromValue(String v) {
        return valueOf(v);
    }

}
