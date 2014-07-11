
package org.onvif.ver10.schema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;


/**
 * <p>Java class for PTZConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PTZConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onvif.org/ver10/schema}ConfigurationEntity">
 *       &lt;sequence>
 *         &lt;element name="NodeToken" type="{http://www.onvif.org/ver10/schema}ReferenceToken"/>
 *         &lt;element name="DefaultAbsolutePantTiltPositionSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultAbsoluteZoomPositionSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultRelativePanTiltTranslationSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultRelativeZoomTranslationSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultContinuousPanTiltVelocitySpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultContinuousZoomVelocitySpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="DefaultPTZSpeed" type="{http://www.onvif.org/ver10/schema}PTZSpeed" minOccurs="0"/>
 *         &lt;element name="DefaultPTZTimeout" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="PanTiltLimits" type="{http://www.onvif.org/ver10/schema}PanTiltLimits" minOccurs="0"/>
 *         &lt;element name="ZoomLimits" type="{http://www.onvif.org/ver10/schema}ZoomLimits" minOccurs="0"/>
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}PTZConfigurationExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PTZConfiguration", propOrder = {
    "nodeToken",
    "defaultAbsolutePantTiltPositionSpace",
    "defaultAbsoluteZoomPositionSpace",
    "defaultRelativePanTiltTranslationSpace",
    "defaultRelativeZoomTranslationSpace",
    "defaultContinuousPanTiltVelocitySpace",
    "defaultContinuousZoomVelocitySpace",
    "defaultPTZSpeed",
    "defaultPTZTimeout",
    "panTiltLimits",
    "zoomLimits",
    "extension"
})
public class PTZConfiguration
    extends ConfigurationEntity
{

    @XmlElement(name = "NodeToken", required = true)
    protected String nodeToken;
    @XmlElement(name = "DefaultAbsolutePantTiltPositionSpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultAbsolutePantTiltPositionSpace;
    @XmlElement(name = "DefaultAbsoluteZoomPositionSpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultAbsoluteZoomPositionSpace;
    @XmlElement(name = "DefaultRelativePanTiltTranslationSpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultRelativePanTiltTranslationSpace;
    @XmlElement(name = "DefaultRelativeZoomTranslationSpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultRelativeZoomTranslationSpace;
    @XmlElement(name = "DefaultContinuousPanTiltVelocitySpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultContinuousPanTiltVelocitySpace;
    @XmlElement(name = "DefaultContinuousZoomVelocitySpace")
    @XmlSchemaType(name = "anyURI")
    protected String defaultContinuousZoomVelocitySpace;
    @XmlElement(name = "DefaultPTZSpeed")
    protected PTZSpeed defaultPTZSpeed;
    @XmlElement(name = "DefaultPTZTimeout")
    protected Duration defaultPTZTimeout;
    @XmlElement(name = "PanTiltLimits")
    protected PanTiltLimits panTiltLimits;
    @XmlElement(name = "ZoomLimits")
    protected ZoomLimits zoomLimits;
    @XmlElement(name = "Extension")
    protected PTZConfigurationExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the nodeToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeToken() {
        return nodeToken;
    }

    /**
     * Sets the value of the nodeToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeToken(String value) {
        this.nodeToken = value;
    }

    /**
     * Gets the value of the defaultAbsolutePantTiltPositionSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultAbsolutePantTiltPositionSpace() {
        return defaultAbsolutePantTiltPositionSpace;
    }

    /**
     * Sets the value of the defaultAbsolutePantTiltPositionSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultAbsolutePantTiltPositionSpace(String value) {
        this.defaultAbsolutePantTiltPositionSpace = value;
    }

    /**
     * Gets the value of the defaultAbsoluteZoomPositionSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultAbsoluteZoomPositionSpace() {
        return defaultAbsoluteZoomPositionSpace;
    }

    /**
     * Sets the value of the defaultAbsoluteZoomPositionSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultAbsoluteZoomPositionSpace(String value) {
        this.defaultAbsoluteZoomPositionSpace = value;
    }

    /**
     * Gets the value of the defaultRelativePanTiltTranslationSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultRelativePanTiltTranslationSpace() {
        return defaultRelativePanTiltTranslationSpace;
    }

    /**
     * Sets the value of the defaultRelativePanTiltTranslationSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultRelativePanTiltTranslationSpace(String value) {
        this.defaultRelativePanTiltTranslationSpace = value;
    }

    /**
     * Gets the value of the defaultRelativeZoomTranslationSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultRelativeZoomTranslationSpace() {
        return defaultRelativeZoomTranslationSpace;
    }

    /**
     * Sets the value of the defaultRelativeZoomTranslationSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultRelativeZoomTranslationSpace(String value) {
        this.defaultRelativeZoomTranslationSpace = value;
    }

    /**
     * Gets the value of the defaultContinuousPanTiltVelocitySpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultContinuousPanTiltVelocitySpace() {
        return defaultContinuousPanTiltVelocitySpace;
    }

    /**
     * Sets the value of the defaultContinuousPanTiltVelocitySpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultContinuousPanTiltVelocitySpace(String value) {
        this.defaultContinuousPanTiltVelocitySpace = value;
    }

    /**
     * Gets the value of the defaultContinuousZoomVelocitySpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultContinuousZoomVelocitySpace() {
        return defaultContinuousZoomVelocitySpace;
    }

    /**
     * Sets the value of the defaultContinuousZoomVelocitySpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultContinuousZoomVelocitySpace(String value) {
        this.defaultContinuousZoomVelocitySpace = value;
    }

    /**
     * Gets the value of the defaultPTZSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link PTZSpeed }
     *     
     */
    public PTZSpeed getDefaultPTZSpeed() {
        return defaultPTZSpeed;
    }

    /**
     * Sets the value of the defaultPTZSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link PTZSpeed }
     *     
     */
    public void setDefaultPTZSpeed(PTZSpeed value) {
        this.defaultPTZSpeed = value;
    }

    /**
     * Gets the value of the defaultPTZTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDefaultPTZTimeout() {
        return defaultPTZTimeout;
    }

    /**
     * Sets the value of the defaultPTZTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDefaultPTZTimeout(Duration value) {
        this.defaultPTZTimeout = value;
    }

    /**
     * Gets the value of the panTiltLimits property.
     * 
     * @return
     *     possible object is
     *     {@link PanTiltLimits }
     *     
     */
    public PanTiltLimits getPanTiltLimits() {
        return panTiltLimits;
    }

    /**
     * Sets the value of the panTiltLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link PanTiltLimits }
     *     
     */
    public void setPanTiltLimits(PanTiltLimits value) {
        this.panTiltLimits = value;
    }

    /**
     * Gets the value of the zoomLimits property.
     * 
     * @return
     *     possible object is
     *     {@link ZoomLimits }
     *     
     */
    public ZoomLimits getZoomLimits() {
        return zoomLimits;
    }

    /**
     * Sets the value of the zoomLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoomLimits }
     *     
     */
    public void setZoomLimits(ZoomLimits value) {
        this.zoomLimits = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link PTZConfigurationExtension }
     *     
     */
    public PTZConfigurationExtension getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link PTZConfigurationExtension }
     *     
     */
    public void setExtension(PTZConfigurationExtension value) {
        this.extension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
