
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PTZPresetTourState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PTZPresetTourState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Idle"/>
 *     &lt;enumeration value="Touring"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PTZPresetTourState")
@XmlEnum
public enum PTZPresetTourState {

    @XmlEnumValue("Idle")
    IDLE("Idle"),
    @XmlEnumValue("Touring")
    TOURING("Touring"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    PTZPresetTourState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PTZPresetTourState fromValue(String v) {
        for (PTZPresetTourState c: PTZPresetTourState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
