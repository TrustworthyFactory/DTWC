/*
 *		OPTET Factory
 *
 *	Class ContextImpl 1.0 6 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Context;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class ContextImpl implements Context, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Context context_p;
	private MyFactory factory; 
	/**
	 * @param context_p
	 * @param factory
	 */
	public ContextImpl(com.thalesgroup.dtwc.protege.Context context_p,
			MyFactory factory) {
		this.context_p = context_p;
		this.factory = factory;
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return context_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		context_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Context#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			context_p.removeID(getId());
		}
		context_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Context#getId()
	 */
	@Override
	public String getId() {
		if (context_p.hasID()){
			return context_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
