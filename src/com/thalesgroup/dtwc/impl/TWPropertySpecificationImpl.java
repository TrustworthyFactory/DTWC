/*
 *		OPTET Factory
 *
 *	Class TWPropertySpecificationImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Control;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.TWProperty;
import com.thalesgroup.dtwc.TWPropertySpecification;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class TWPropertySpecificationImpl implements TWPropertySpecification, ObjectManagement {

	private MyFactory factory;
	private com.thalesgroup.dtwc.protege.TWPropertySpecification problemSpec_p;
	private ControlImpl control;
	private TWPropertyImpl twProperty;
	
	/**
	 * @param problemSpec_p
	 * @param factory 
	 */
	protected TWPropertySpecificationImpl(com.thalesgroup.dtwc.protege.TWPropertySpecification problemSpec_p, MyFactory factory) {
		this.factory = factory;
		this.problemSpec_p =problemSpec_p; 
		
		
		// check if control already exist
		Collection<? extends WrappedIndividual> controlCol = problemSpec_p.getHasControl();
		for (Iterator iterator = controlCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Control control_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Control.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(control_p.getOwlIndividual().toStringID());	
			control = new ControlImpl(control_p, factory);
			break;
		}
		
		// check if twProperty already exist
		Collection<? extends WrappedIndividual> twPropertyCol = problemSpec_p.getHasTWProperty();
		for (Iterator iterator = twPropertyCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.TWProperty twProperty_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.TWProperty.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(twProperty_p.getOwlIndividual().toStringID());	
			twProperty = new TWPropertyImpl(twProperty_p, factory);
			break;
		}
		
		
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return problemSpec_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#addControl(java.lang.String)
	 */
	@Override
	public Control addControl(String name) {
		com.thalesgroup.dtwc.protege.Control control_p = factory.createControl(name);
		control_p.addID(name);
		problemSpec_p.addHasControl(control_p);
		control = new ControlImpl(control_p, factory);
		return control;
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#removeControl(java.lang.String)
	 */
	@Override
	public void removeControl(String name) {
		problemSpec_p.removeHasControl(control.getProtegeObject());
		control = null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#getControl()
	 */
	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return control;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#addTWProperty(com.thalesgroup.TWProperty)
	 */
	@Override
	public TWProperty addTWProperty(String name) {
		com.thalesgroup.dtwc.protege.TWProperty twProperty_p = factory.createTWProperty(name);
		twProperty_p.addID(name);
		problemSpec_p.addHasTWProperty(twProperty_p);
		twProperty = new TWPropertyImpl(twProperty_p, factory);
		return twProperty;
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#removeTWProperty(java.lang.String)
	 */
	@Override
	public void removeTWProperty(String name) {
		problemSpec_p.removeHasTWProperty(twProperty.getProtegeObject());
		twProperty = null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWPropertySpecification#getTWProperty()
	 */
	@Override
	public TWProperty getTWProperty() {
		// TODO Auto-generated method stub
		return twProperty;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if (control != null){
			control.clear();
		}
		if (twProperty != null){
			twProperty.clear();
		}
		problemSpec_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWPropertySpecification#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			problemSpec_p.removeID(getId());
		}
		problemSpec_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWPropertySpecification#getId()
	 */
	@Override
	public String getId() {
		if (problemSpec_p.hasID()){
			return problemSpec_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
