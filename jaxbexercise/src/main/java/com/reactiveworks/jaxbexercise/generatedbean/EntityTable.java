//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.18 at 10:30:01 AM IST 
//


package com.reactiveworks.jaxbexercise.generatedbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityColumns">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EntityColumn" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Attribute" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="attributeDatatype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="type">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="MANUAL"/>
 *                                           &lt;enumeration value="NATIVE"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="entityFieldNameRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="hasAutoIncrement" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="sequence" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EntityIndexs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EntityIndex">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="entityColumnRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="autoCreate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="tablename" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entityColumns",
    "entityIndexs"
})
public class EntityTable {

    @XmlElement(name = "EntityColumns", required = true)
    protected EntityColumns entityColumns;
    @XmlElement(name = "EntityIndexs", required = true)
    protected EntityIndexs entityIndexs;
    @XmlAttribute(name = "autoCreate")
    protected Boolean autoCreate;
    @XmlAttribute(name = "tablename")
    protected String tablename;

    /**
     * Gets the value of the entityColumns property.
     * 
     * @return
     *     possible object is
     *     {@link EntityColumns }
     *     
     */
    public EntityColumns getEntityColumns() {
        return entityColumns;
    }

    /**
     * Sets the value of the entityColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityColumns }
     *     
     */
    public void setEntityColumns(EntityColumns value) {
        this.entityColumns = value;
    }

    /**
     * Gets the value of the entityIndexs property.
     * 
     * @return
     *     possible object is
     *     {@link EntityIndexs }
     *     
     */
    public EntityIndexs getEntityIndexs() {
        return entityIndexs;
    }

    /**
     * Sets the value of the entityIndexs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityIndexs }
     *     
     */
    public void setEntityIndexs(EntityIndexs value) {
        this.entityIndexs = value;
    }

    /**
     * Gets the value of the autoCreate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoCreate() {
        return autoCreate;
    }

    /**
     * Sets the value of the autoCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoCreate(Boolean value) {
        this.autoCreate = value;
    }

    /**
     * Gets the value of the tablename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTablename() {
        return tablename;
    }

    /**
     * Sets the value of the tablename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTablename(String value) {
        this.tablename = value;
    }

}