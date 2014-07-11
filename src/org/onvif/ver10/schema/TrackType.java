
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Video"/>
 *     &lt;enumeration value="Audio"/>
 *     &lt;enumeration value="Metadata"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackType")
@XmlEnum
public enum TrackType {

    @XmlEnumValue("Video")
    VIDEO("Video"),
    @XmlEnumValue("Audio")
    AUDIO("Audio"),
    @XmlEnumValue("Metadata")
    METADATA("Metadata"),

    /**
     * Placeholder for future extension.
     * 
     */
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    TrackType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrackType fromValue(String v) {
        for (TrackType c: TrackType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
