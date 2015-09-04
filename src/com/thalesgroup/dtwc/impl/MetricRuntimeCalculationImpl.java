/*
 *		OPTET Factory
 *
 *	Class MetricRuntimeCalculation 1.0 28 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Genneviliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Metric;
import com.thalesgroup.dtwc.MetricRuntimeCalculation;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class MetricRuntimeCalculationImpl implements MetricRuntimeCalculation, ObjectManagement{

	private com.thalesgroup.dtwc.protege.MetricRuntimeCalculation metricRuntimeCalculation_p;
	private MyFactory factory;
	private String value;
	
	
	
	public MetricRuntimeCalculationImpl(com.thalesgroup.dtwc.protege.MetricRuntimeCalculation metricRuntimeCalculation_p, MyFactory factory) {
		this.metricRuntimeCalculation_p = metricRuntimeCalculation_p;
		this.factory = factory;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWAttribute#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			metricRuntimeCalculation_p.removeID(getId());
		}
		metricRuntimeCalculation_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWAttribute#getId()
	 */
	@Override
	public String getId() {
		if (metricRuntimeCalculation_p.hasID()){
			return metricRuntimeCalculation_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		metricRuntimeCalculation_p.addHasValue(value);
		this.value=value;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#getValue()
	 */
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.ObjectManagement#getProtegeObject()
	 */
	@Override
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return metricRuntimeCalculation_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		metricRuntimeCalculation_p.delete();
	}
}
