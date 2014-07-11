
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for RelayOutputSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelayOutputSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.onvif.org/ver10/schema}RelayMode"/>
 *         &lt;element name="DelayTime" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *         &lt;element name="IdleState" type="{http://www.onvif.org/ver10/schema}RelayIdleState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelayOutputSettings", propOrder = {
    "mode",
    "delayTime",
    "idleState"
})
public class RelayOutputSettings {

    @XmlElement(name = "Mode", required = true)
    protected RelayMode mode;
    @XmlElement(name = "DelayTime", required = true)
    protected Duration delayTime;
    @XmlElement(name = "IdleState", required = true)
    protected RelayIdleState idleState;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link RelayMode }
     *     
     */
    public RelayMode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelayMode }
     *     
     */
    public void setMode(RelayMode value) {
        this.mode = value;
    }

    /**
     * Gets the value of the delayTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDelayTime() {
        return delayTime;
    }

    /**
     * Sets the value of the delayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDelayTime(Duration value) {
        this.delayTime = value;
    }

    /**
     * Gets the value of the idleState property.
     * 
     * @return
     *     possible object is
     *     {@link RelayIdleState }
     *     
     */
    public RelayIdleState getIdleState() {
        return idleState;
    }

    /**
     * Sets the value of the idleState property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelayIdleState }
     *     
     */
    public void setIdleState(RelayIdleState value) {
        this.idleState = value;
    }

}
