/*
 *		OPTET Factory
 *
 *	Class MetricImpl 1.0 6 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Metric;
import com.thalesgroup.dtwc.MetricRuntimeCalculation;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class MetricImpl implements Metric, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Metric metric_p;
	private MyFactory factory;
	private Map<String, MetricRuntimeCalculationImpl> MetricRCMap;
	
	private String value;
	private String unit;
	
	/**
	 * @param metric_p
	 * @param factory
	 */
	public MetricImpl(com.thalesgroup.dtwc.protege.Metric metric_p, MyFactory factory) {
		this.factory = factory;
		this.metric_p = metric_p;
		
		MetricRCMap = new HashMap();
		
		Collection<? extends Object> valueCol = metric_p.getHasValue();
		for (Iterator iterator = valueCol.iterator(); iterator.hasNext();) {
			value = (String) iterator.next();
			System.out.println(value);	
			break;
		}
		
		Collection<? extends Object> unitCol = metric_p.getHasUnit();
		for (Iterator iterator = unitCol.iterator(); iterator.hasNext();) {
			unit = (String) iterator.next();
			System.out.println(unit);	
			break;
		}
		
		// check if some  metric already exist		
		Collection<? extends WrappedIndividual> metricCMCol = metric_p.getHasMetricCalculationMethod();
		for (Iterator iterator = metricCMCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.MetricRuntimeCalculation metricCM_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.MetricRuntimeCalculation.class);
			//dtwc_p.addHasTWProblemDefinition(problemDef_p);
			System.out.println(metricCM_p.getOwlIndividual().toStringID());	
			MetricRCMap.put(metricCM_p.getOwlIndividual().toStringID(), new MetricRuntimeCalculationImpl(metricCM_p, factory));
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		metric_p.addHasValue(value);
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
	 * @see com.thalesgroup.Metric#setUnit(java.lang.String)
	 */
	@Override
	public void setUnit(String unit) {
		metric_p.addHasUnit(unit);
		this.unit = unit;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#getUnit()
	 */
	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return unit;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {

		if (getType()!=null){
			metric_p.removeType(getType());
		}
		metric_p.addType(type);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#getType()
	 */
	@Override
	public String getType() {
		if (metric_p.hasType()){
			return metric_p.getType().iterator().next();
		}else { 
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#addMetricRuntimeCalculation(com.thalesgroup.MetricRuntimeCalculation)
	 */
	@Override
	public MetricRuntimeCalculation addMetricRuntimeCalculation(String name) {
		com.thalesgroup.dtwc.protege.MetricRuntimeCalculation metricRC_p = factory.createMetricRuntimeCalculation(name);
		metricRC_p.addID(name);
		metric_p.addHasMetricCalculationMethod(metricRC_p);
		MetricRuntimeCalculationImpl metricRC = new MetricRuntimeCalculationImpl(metricRC_p, factory);
		MetricRCMap.put(name, metricRC);
		return metricRC;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#removeMetricRuntimeCalculation(java.lang.String)
	 */
	@Override
	public void removeMetricRuntimeCalculation(String name) {
		metric_p.removeHasMetricCalculationMethod(MetricRCMap.get(name).getProtegeObject());
		MetricRCMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Metric#getMetricRuntimeCalculationList()
	 */
	@Override
	public Collection<MetricRuntimeCalculationImpl> getMetricRuntimeCalculationList() {
		// TODO Auto-generated method stub
		return MetricRCMap.values();
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		metric_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Metric#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			metric_p.removeID(getId());
		}
		metric_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Metric#getId()
	 */
	@Override
	public String getId() {
		if (metric_p.hasID()){
			return metric_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
