/*
 *		OPTET Factory
 *
 *	Class Metric 1.0 28 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;
import java.util.List;

import com.thalesgroup.dtwc.impl.MetricRuntimeCalculationImpl;

/**
 * @author F. Motte
 *
 */
public interface Metric {

	public void setValue(String value);
	
	public String getValue();
	
	public void setUnit(String unit);
	
	public String getUnit();
	
	public void setType(String type);
	
	public String getType();
	
	public MetricRuntimeCalculation addMetricRuntimeCalculation(String mrc);
	
	public void removeMetricRuntimeCalculation(String name);
	
	Collection<MetricRuntimeCalculationImpl> getMetricRuntimeCalculationList();
	
	// ID
	public void setId(String ID);
	
	public String getId();

	
}
