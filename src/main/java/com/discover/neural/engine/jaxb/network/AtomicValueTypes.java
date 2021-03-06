//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.20 at 01:50:07 PM GMT 
//


package com.discover.neural.engine.jaxb.network;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atomic_value_types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="atomic_value_types">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="string"/>
 *     &lt;enumeration value="integer"/>
 *     &lt;enumeration value="double"/>
 *     &lt;enumeration value="complex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "atomic_value_types", namespace = "http://neural.discover.com/enumerations")
@XmlEnum
public enum AtomicValueTypes {

    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("integer")
    INTEGER("integer"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("complex")
    COMPLEX("complex");
    private final String value;

    AtomicValueTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AtomicValueTypes fromValue(String v) {
        for (AtomicValueTypes c: AtomicValueTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
