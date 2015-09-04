/*
 *		OPTET Factory
 *
 *	Class ThreatImpl 1.0 5 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.Iterator;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Control;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.Threat;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class ThreatImpl implements Threat, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Threat threat_p;
	private MyFactory factory;
	private ControlImpl control;
	private String type = null;
	/**
	 * @param threat_p
	 * @param factory
	 */
	public ThreatImpl(com.thalesgroup.dtwc.protege.Threat threat_p, MyFactory factory) {
		this.factory = factory;
		this.threat_p = threat_p;
		
		
		// check if threat already exist
		Collection<? extends WrappedIndividual> controlCol = threat_p.getHasControl();
		for (Iterator iterator = controlCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Control control_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Control.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(control_p.getOwlIndividual().toStringID());	
			control = new ControlImpl(control_p, factory);
			break;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Threat#addControl(com.thalesgroup.Control)
	 */
	@Override
	public Control addControl(String name) {
		com.thalesgroup.dtwc.protege.Control control_p = factory.createControl(name);
		control_p.addID(name);
		threat_p.addHasControl(control_p);
		control = new ControlImpl(control_p, factory);
		return control;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Threat#removeControl(java.lang.String)
	 */
	@Override
	public void removeControl(String name) {
		threat_p.removeHasControl(control.getProtegeObject());
		control = null;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Threat#getControl()
	 */
	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return control;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Threat#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			threat_p.removeType(getType());
		}
		this.type = type;
		threat_p.addType(type);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Threat#getType()
	 */
	@Override
	public String getType() {
		if (threat_p.hasType()){
			return threat_p.getType().iterator().next();
		}else { 
			return null;
		}
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return threat_p;
	}

	/**
	 * 
	 */
	public void clear() {
		// TODO Auto-generated method stub
		if (control != null){
			control.clear();
		}
		threat_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Threat#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			threat_p.removeID(getId());
		}
		threat_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Threat#getId()
	 */
	@Override
	public String getId() {
		if (threat_p.hasID()){
			return threat_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
