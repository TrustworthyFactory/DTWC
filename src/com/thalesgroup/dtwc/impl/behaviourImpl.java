/*
 *		OPTET Factory
 *
 *	Class behaviourImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Behaviour;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.Component;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class behaviourImpl implements Behaviour, ObjectManagement {

	private MyFactory factory;
	private com.thalesgroup.dtwc.protege.Behaviour behaviour_p;

	/**
	 * @param behaviour_p
	 * @param factory
	 */
	public behaviourImpl(com.thalesgroup.dtwc.protege.Behaviour behaviour_p,
			MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.behaviour_p = behaviour_p;
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return behaviour_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		behaviour_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Behaviour#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			behaviour_p.removeID(getId());
		}
		behaviour_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Behaviour#getId()
	 */
	@Override
	public String getId() {
		if (behaviour_p.hasID()){
			return behaviour_p.getID().iterator().next();
		}else { 
			return null;
		}
	}


}
