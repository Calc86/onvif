
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				The TZ format is specified by POSIX, please refer to POSIX 1003.1 section 8.3
 * 				Example: Europe, Paris TZ=CET-1CEST,M3.5.0/2,M10.5.0/3
 * 				CET = designation for standard time when daylight saving is not in force
 * 				-1 = offset in hours = negative so 1 hour east of Greenwich meridian
 * 				CEST = designation when daylight saving is in force ("Central European Summer Time")
 * 				, = no offset number between code and comma, so default to one hour ahead for daylight saving
 * 				M3.5.0 = when daylight saving starts = the last Sunday in March (the "5th" week means the last in the month)
 * 				/2, = the local time when the switch occurs = 2 a.m. in this case
 * 				M10.5.0 = when daylight saving ends = the last Sunday in October.
 * 				/3, = the local time when the switch occurs = 3 a.m. in this case
 * 			
 * 
 * <p>Java class for TimeZone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeZone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TZ" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeZone", propOrder = {
    "tz"
})
public class TimeZone {

    @XmlElement(name = "TZ", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String tz;

    /**
     * Gets the value of the tz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTZ() {
        return tz;
    }

    /**
     * Sets the value of the tz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTZ(String value) {
        this.tz = value;
    }

}
