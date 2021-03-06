//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.20 at 01:50:07 PM GMT 
//


package com.discover.neural.engine.jaxb.network;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for networkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="networkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="neurons" type="{http://neural.discover.com/networks}neuronsType"/>
 *         &lt;element name="input-signals" type="{http://neural.discover.com/networks}inputSignalsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "networkType", propOrder = {
    "neurons",
    "inputSignals"
})
public class NetworkType {

    @XmlElement(required = true)
    protected NeuronsType neurons;
    @XmlElement(name = "input-signals")
    protected InputSignalsType inputSignals;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the neurons property.
     * 
     * @return
     *     possible object is
     *     {@link NeuronsType }
     *     
     */
    public NeuronsType getNeurons() {
        return neurons;
    }

    /**
     * Sets the value of the neurons property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeuronsType }
     *     
     */
    public void setNeurons(NeuronsType value) {
        this.neurons = value;
    }

    /**
     * Gets the value of the inputSignals property.
     * 
     * @return
     *     possible object is
     *     {@link InputSignalsType }
     *     
     */
    public InputSignalsType getInputSignals() {
        return inputSignals;
    }

    /**
     * Sets the value of the inputSignals property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputSignalsType }
     *     
     */
    public void setInputSignals(InputSignalsType value) {
        this.inputSignals = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
