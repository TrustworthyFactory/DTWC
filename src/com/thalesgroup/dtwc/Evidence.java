/*
 *		OPTET Factory
 *
 *	Class Evidences 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;

import com.thalesgroup.dtwc.impl.ComponentImpl;
import com.thalesgroup.dtwc.impl.MetricImpl;

/**
 * @author F. Motte
 *
 */
public interface Evidence {

	// Component
	public Metric addMetric(String name);
	
	public void removeMetric(String name);
	
	Collection<MetricImpl> getMetricList();
	
	public Metric getMetric(String name);
	
	// ID
	public void setId(String ID);
	
	public String getId();
}
