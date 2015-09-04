/*
 *		OPTET Factory
 *
 *	Class EvidenceImpl 1.0 3 mars 2014
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
import java.util.Map;
import java.util.Set;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Evidence;
import com.thalesgroup.dtwc.Metric;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class EvidenceImpl implements Evidence, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Evidence ev_p;
	private MyFactory factory;
	private Map<String, MetricImpl> MetricMap;
	
	/**
	 * @param ev_p
	 * @param factory 
	 */
	public EvidenceImpl(com.thalesgroup.dtwc.protege.Evidence ev_p, MyFactory factory) {
		this.ev_p = ev_p;
		this.factory = factory;
		
		MetricMap = new HashMap();
		
		// check if some  metric already exist		
		Collection<? extends WrappedIndividual> metricCol = ev_p.getHasMetric();
		for (Iterator iterator = metricCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Metric metric_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Metric.class);
			//dtwc_p.addHasTWProblemDefinition(problemDef_p);
			System.out.println(metric_p.getOwlIndividual().toStringID());	
			MetricMap.put(metric_p.getOwlIndividual().toStringID(), new MetricImpl(metric_p, factory));
		}
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return ev_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Evidence#addMetric(java.lang.String)
	 */
	@Override
	public Metric addMetric(String name) {
		com.thalesgroup.dtwc.protege.Metric metric_p = factory.createMetric(name);
		metric_p.addID(name);
		ev_p.addHasMetric(metric_p);
		MetricImpl metric = new MetricImpl(metric_p, factory);
		MetricMap.put(name, metric);
		return metric;
	}

	public Metric getMetric(String name){
		return MetricMap.get(name);
	}
	
	/* (non-Javadoc)
	 * @see com.thalesgroup.Evidence#removeMetric(java.lang.String)
	 */
	@Override
	public void removeMetric(String name) {
		ev_p.removeHasMetric(MetricMap.get(name).getProtegeObject());
		MetricMap.remove(name);
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Evidence#getMetricList()
	 */
	@Override
	public Collection<MetricImpl> getMetricList() {
		// TODO Auto-generated method stub
		return MetricMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		Set<String> keys = MetricMap.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			ev_p.removeHasMetric(MetricMap.get(string).getProtegeObject());
			MetricImpl value = MetricMap.get(string);
			value.clear();
		}
		MetricMap.clear();
		ev_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Evidence#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			ev_p.removeID(getId());
		}
		ev_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Evidence#getId()
	 */
	@Override
	public String getId() {
		if (ev_p.hasID()){
			return ev_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
