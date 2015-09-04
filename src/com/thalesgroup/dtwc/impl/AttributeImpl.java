/*
 *		OPTET Factory
 *
 *	Class AttributeImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Attribute;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.Asset;
import com.thalesgroup.dtwc.protege.ComponentModel;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class AttributeImpl implements Attribute, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Attribute attribute_p;
	private MyFactory factory;
	private String type;

	
	/**
	 * @param attribute_p2
	 * @param factory2
	 */
	public AttributeImpl(com.thalesgroup.dtwc.protege.Attribute attribute_p,
			MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.attribute_p = attribute_p;
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#getProtegeObject()
	 */
	@Override
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return attribute_p;
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		attribute_p.delete();
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Attribute#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			attribute_p.removeID(getId());
		}
		attribute_p.addID(ID);

	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Attribute#getId()
	 */
	@Override
	public String getId() {
		if (attribute_p.hasID()){
			return attribute_p.getID().iterator().next();
		}else { 
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Attribute#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			attribute_p.removeType(getType());
		}
		this.type = type;
		attribute_p.addType(type);
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Attribute#getType()
	 */
	@Override
	public String getType() {
		if (attribute_p.hasType()){
			return attribute_p.getType().iterator().next();
		}else { 
			return null;
		}
	}


}
