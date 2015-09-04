/*
 *		OPTET Factory
 *
 *	Class ControlImpl 1.0 5 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Control;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class ControlImpl implements Control, ObjectManagement {

	private MyFactory factory;
	private com.thalesgroup.dtwc.protege.Control control_p;
	/**
	 * @param control_p
	 * @param factory
	 */
	public ControlImpl(com.thalesgroup.dtwc.protege.Control control_p,
			MyFactory factory) {
		this.factory = factory; 
		this.control_p = control_p;

	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return control_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		control_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Control#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		control_p.addID(ID);
		if (getId()!=null){
			control_p.removeID(getId());
		}
		control_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Control#getId()
	 */
	@Override
	public String getId() {
		if (control_p.hasID()){
			return control_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Control#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			control_p.removeType(getType());
		}
		control_p.addType(type);
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Control#getType()
	 */
	@Override
	public String getType() {
		if (control_p.hasType()){
			return control_p.getType().iterator().next();
		}else { 
			return null;
		}
	}

}
