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
 *       &lt;all>
 *         &lt;element name="EntityReadKeysMapping" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{http://www.example.org/entity}EntityKeyGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EntityFilterKeysMapping" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{http://www.example.org/entity}EntityKeyGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EntityInsertKeysMapping" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{http://www.example.org/entity}EntityKeyGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EntityUpdateKeysMapping" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{http://www.example.org/entity}EntityKeyGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LDCResponseConfigs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ApplyLDCConfig">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LDCSchema">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="schemaFileName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="LDCProjection">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="projectionFileName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="projectionSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="LDCTaxonomy">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="applyAt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="sequence" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="accessMethod" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accessType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="authorizedResource" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isCollection" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class EntityAccess {

    @XmlElement(name = "EntityReadKeysMapping")
    protected EntityReadKeysMapping entityReadKeysMapping;
    @XmlElement(name = "EntityFilterKeysMapping")
    protected EntityFilterKeysMapping entityFilterKeysMapping;
    @XmlElement(name = "EntityInsertKeysMapping")
    protected EntityInsertKeysMapping entityInsertKeysMapping;
    @XmlElement(name = "EntityUpdateKeysMapping")
    protected EntityUpdateKeysMapping entityUpdateKeysMapping;
    @XmlElement(name = "LDCResponseConfigs")
    protected LDCResponseConfigs ldcResponseConfigs;
    @XmlAttribute(name = "accessMethod", required = true)
    protected String accessMethod;
    @XmlAttribute(name = "accessType", required = true)
    protected String accessType;
    @XmlAttribute(name = "authorizedResource", required = true)
    protected String authorizedResource;
    @XmlAttribute(name = "isCollection")
    protected Boolean isCollection;

    /**
     * Gets the value of the entityReadKeysMapping property.
     * 
     * @return
     *     possible object is
     *     {@link EntityReadKeysMapping }
     *     
     */
    public EntityReadKeysMapping getEntityReadKeysMapping() {
        return entityReadKeysMapping;
    }

    /**
     * Sets the value of the entityReadKeysMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityReadKeysMapping }
     *     
     */
    public void setEntityReadKeysMapping(EntityReadKeysMapping value) {
        this.entityReadKeysMapping = value;
    }

    /**
     * Gets the value of the entityFilterKeysMapping property.
     * 
     * @return
     *     possible object is
     *     {@link EntityFilterKeysMapping }
     *     
     */
    public EntityFilterKeysMapping getEntityFilterKeysMapping() {
        return entityFilterKeysMapping;
    }

    /**
     * Sets the value of the entityFilterKeysMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityFilterKeysMapping }
     *     
     */
    public void setEntityFilterKeysMapping(EntityFilterKeysMapping value) {
        this.entityFilterKeysMapping = value;
    }

    /**
     * Gets the value of the entityInsertKeysMapping property.
     * 
     * @return
     *     possible object is
     *     {@link EntityInsertKeysMapping }
     *     
     */
    public EntityInsertKeysMapping getEntityInsertKeysMapping() {
        return entityInsertKeysMapping;
    }

    /**
     * Sets the value of the entityInsertKeysMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityInsertKeysMapping }
     *     
     */
    public void setEntityInsertKeysMapping(EntityInsertKeysMapping value) {
        this.entityInsertKeysMapping = value;
    }

    /**
     * Gets the value of the entityUpdateKeysMapping property.
     * 
     * @return
     *     possible object is
     *     {@link EntityUpdateKeysMapping }
     *     
     */
    public EntityUpdateKeysMapping getEntityUpdateKeysMapping() {
        return entityUpdateKeysMapping;
    }

    /**
     * Sets the value of the entityUpdateKeysMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityUpdateKeysMapping }
     *     
     */
    public void setEntityUpdateKeysMapping(EntityUpdateKeysMapping value) {
        this.entityUpdateKeysMapping = value;
    }

    /**
     * Gets the value of the ldcResponseConfigs property.
     * 
     * @return
     *     possible object is
     *     {@link LDCResponseConfigs }
     *     
     */
    public LDCResponseConfigs getLDCResponseConfigs() {
        return ldcResponseConfigs;
    }

    /**
     * Sets the value of the ldcResponseConfigs property.
     * 
     * @param value
     *     allowed object is
     *     {@link LDCResponseConfigs }
     *     
     */
    public void setLDCResponseConfigs(LDCResponseConfigs value) {
        this.ldcResponseConfigs = value;
    }

    /**
     * Gets the value of the accessMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessMethod() {
        return accessMethod;
    }

    /**
     * Sets the value of the accessMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessMethod(String value) {
        this.accessMethod = value;
    }

    /**
     * Gets the value of the accessType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessType(String value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the authorizedResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedResource() {
        return authorizedResource;
    }

    /**
     * Sets the value of the authorizedResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedResource(String value) {
        this.authorizedResource = value;
    }

    /**
     * Gets the value of the isCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCollection() {
        return isCollection;
    }

    /**
     * Sets the value of the isCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

}
