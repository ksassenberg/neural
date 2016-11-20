//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.20 at 01:50:07 PM GMT 
//


package com.discover.neural.engine.jaxb.network;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for neuronType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="neuronType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bias" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="activation-function" type="{http://neural.discover.com/networks}activation-functionType"/>
 *         &lt;element name="synapses" type="{http://neural.discover.com/networks}synapsesType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://neural.discover.com/enumerations}neuron_type_enum" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "neuronType", propOrder = {
    "bias",
    "activationFunction",
    "synapses"
})
public class NeuronType {

    @XmlElement(required = true)
    protected BigDecimal bias;
    @XmlElement(name = "activation-function", required = true)
    protected ActivationFunctionType activationFunction;
    @XmlElement(required = true)
    protected SynapsesType synapses;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type")
    protected NeuronTypeEnum type;

    /**
     * Gets the value of the bias property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBias() {
        return bias;
    }

    /**
     * Sets the value of the bias property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBias(BigDecimal value) {
        this.bias = value;
    }

    /**
     * Gets the value of the activationFunction property.
     * 
     * @return
     *     possible object is
     *     {@link ActivationFunctionType }
     *     
     */
    public ActivationFunctionType getActivationFunction() {
        return activationFunction;
    }

    /**
     * Sets the value of the activationFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationFunctionType }
     *     
     */
    public void setActivationFunction(ActivationFunctionType value) {
        this.activationFunction = value;
    }

    /**
     * Gets the value of the synapses property.
     * 
     * @return
     *     possible object is
     *     {@link SynapsesType }
     *     
     */
    public SynapsesType getSynapses() {
        return synapses;
    }

    /**
     * Sets the value of the synapses property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynapsesType }
     *     
     */
    public void setSynapses(SynapsesType value) {
        this.synapses = value;
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

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link NeuronTypeEnum }
     *     
     */
    public NeuronTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeuronTypeEnum }
     *     
     */
    public void setType(NeuronTypeEnum value) {
        this.type = value;
    }

}
