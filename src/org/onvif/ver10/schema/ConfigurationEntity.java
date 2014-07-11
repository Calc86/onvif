
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type defining the common properties of a configuration.
 * 
 * <p>Java class for ConfigurationEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigurationEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.onvif.org/ver10/schema}Name"/>
 *         &lt;element name="UseCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="token" use="required" type="{http://www.onvif.org/ver10/schema}ReferenceToken" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigurationEntity", propOrder = {
    "name",
    "useCount"
})
@XmlSeeAlso({
    AudioSourceConfiguration.class,
    PTZConfiguration.class,
    VideoSourceConfiguration.class,
    AudioEncoderConfiguration.class,
    VideoEncoderConfiguration.class,
    AudioDecoderConfiguration.class,
    VideoAnalyticsConfiguration.class,
    AudioOutputConfiguration.class,
    MetadataConfiguration.class,
    AnalyticsEngineInput.class,
    AnalyticsEngineControl.class,
    AnalyticsEngine.class,
    VideoOutputConfiguration.class
})
public class ConfigurationEntity {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "UseCount")
    protected int useCount;
    @XmlAttribute(name = "token", required = true)
    protected String token;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the useCount property.
     * 
     */
    public int getUseCount() {
        return useCount;
    }

    /**
     * Sets the value of the useCount property.
     * 
     */
    public void setUseCount(int value) {
        this.useCount = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
