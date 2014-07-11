
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for H264Configuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="H264Configuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GovLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="H264Profile" type="{http://www.onvif.org/ver10/schema}H264Profile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "H264Configuration", propOrder = {
    "govLength",
    "h264Profile"
})
public class H264Configuration {

    @XmlElement(name = "GovLength")
    protected int govLength;
    @XmlElement(name = "H264Profile", required = true)
    protected H264Profile h264Profile;

    /**
     * Gets the value of the govLength property.
     * 
     */
    public int getGovLength() {
        return govLength;
    }

    /**
     * Sets the value of the govLength property.
     * 
     */
    public void setGovLength(int value) {
        this.govLength = value;
    }

    /**
     * Gets the value of the h264Profile property.
     * 
     * @return
     *     possible object is
     *     {@link H264Profile }
     *     
     */
    public H264Profile getH264Profile() {
        return h264Profile;
    }

    /**
     * Sets the value of the h264Profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link H264Profile }
     *     
     */
    public void setH264Profile(H264Profile value) {
        this.h264Profile = value;
    }

}
