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
 * <p>Java class for inputSignalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inputSignalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signal-function" type="{http://neural.discover.com/networks}signal-functionType"/>
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
@XmlType(name = "inputSignalType", propOrder = {
    "signalFunction"
})
public class InputSignalType {

    @XmlElement(name = "signal-function", required = true)
    protected SignalFunctionType signalFunction;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the signalFunction property.
     * 
     * @return
     *     possible object is
     *     {@link SignalFunctionType }
     *     
     */
    public SignalFunctionType getSignalFunction() {
        return signalFunction;
    }

    /**
     * Sets the value of the signalFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalFunctionType }
     *     
     */
    public void setSignalFunction(SignalFunctionType value) {
        this.signalFunction = value;
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