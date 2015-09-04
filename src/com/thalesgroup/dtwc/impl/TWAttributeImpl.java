/*
 *		OPTET Factory
 *
 *	Class TWAttributeImpl 1.0 6 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.TWAttribute;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class TWAttributeImpl implements TWAttribute, ObjectManagement {

	private com.thalesgroup.dtwc.protege.TWAttribute twAtrribute_p;
	private MyFactory factory;
	private String type;
	/**
	 * @param twAtrribute_p
	 * @param factory
	 */
	public TWAttributeImpl(com.thalesgroup.dtwc.protege.TWAttribute twAtrribute_p, MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.twAtrribute_p = twAtrribute_p;
		this.factory = factory;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWAttribute#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			twAtrribute_p.removeType(getType());
		}
		twAtrribute_p.addType(type);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWAttribute#getType()
	 */
	@Override
	public String getType() {
		if (twAtrribute_p.hasType()){
			return twAtrribute_p.getType().iterator().next();
		}else { 
			return null;
		}
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return twAtrribute_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		twAtrribute_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWAttribute#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			twAtrribute_p.removeID(getId());
		}
		twAtrribute_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWAttribute#getId()
	 */
	@Override
	public String getId() {
		if (twAtrribute_p.hasID()){
			return twAtrribute_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
