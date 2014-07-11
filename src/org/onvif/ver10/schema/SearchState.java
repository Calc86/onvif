
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Queued"/>
 *     &lt;enumeration value="Searching"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchState")
@XmlEnum
public enum SearchState {


    /**
     * The search is queued and not yet started.
     * 
     */
    @XmlEnumValue("Queued")
    QUEUED("Queued"),

    /**
     * The search is underway and not yet completed.
     * 
     */
    @XmlEnumValue("Searching")
    SEARCHING("Searching"),

    /**
     * The search has been completed and no new results will be found.
     * 
     */
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),

    /**
     * The state of the search is unknown. (This is not a valid response from GetSearchState.)
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SearchState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchState fromValue(String v) {
        for (SearchState c: SearchState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
