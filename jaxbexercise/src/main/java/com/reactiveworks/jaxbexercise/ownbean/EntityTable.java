package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="EntityTable")
@XmlType(propOrder= {"entityColumns","entityIndexs"})
public class EntityTable {

	private boolean autoCreate;
	private String tablename;
	private EntityColumns entityColumns;
	private EntityIndexs entityIndexs;
	
	@XmlElement(name="EntityIndexs",type=EntityIndexs.class,required=true)
	public EntityIndexs getEntityIndexs() {
		return entityIndexs;
	}
	public void setEntityIndexs(EntityIndexs entityIndexs) {
		this.entityIndexs = entityIndexs;
	}

	@XmlAttribute(name="autoCreate",required=true)
	public boolean isAutoCreate() {
		return autoCreate;
	}
	public void setAutoCreate(boolean autoCreate) {
		this.autoCreate = autoCreate;
	}
	
	@XmlAttribute(name="tablename",required=true)
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	@XmlElement(name="EntityColumns",type=EntityColumns.class,required=true)
	public EntityColumns getEntityColumns() {
		return entityColumns;
	}
	public void setEntityColumns(EntityColumns entityColumns) {
		this.entityColumns = entityColumns;
	}
	
	
}
