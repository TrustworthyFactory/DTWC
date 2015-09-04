/*
 *		OPTET Factory
 *
 *	Class StakeholderImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.protege.Component;
import com.thalesgroup.dtwc.protege.MyFactory;
import com.thalesgroup.dtwc.protege.SystemDescription;

/**
 * @author F. Motte
 *
 */
public class StakeholderImpl implements Stakeholder, ObjectManagement {

	private MyFactory factory = null;
	private com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p = null;
	private String type;

	/**
	 * @param stakeholder_p2
	 * @param factory2
	 */
	public StakeholderImpl(com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p,
			MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.stakeholder_p = stakeholder_p;
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return stakeholder_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stakeholder_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Stakeholder#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			stakeholder_p.removeID(getId());
		}
		stakeholder_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Stakeholder#getId()
	 */
	@Override
	public String getId() {
		if (stakeholder_p.hasID()){
			return stakeholder_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Stakeholder#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			stakeholder_p.removeType(getType());
		}
		this.type = type;
		stakeholder_p.addType(type);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Stakeholder#getType()
	 */
	@Override
	public String getType() {
		if (stakeholder_p.hasType()){
			return stakeholder_p.getType().iterator().next();
		}else { 
			return null;
		}
	}

}
