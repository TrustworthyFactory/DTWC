/*
 *		OPTET Factory
 *
 *	Class MetricRuntimeCalculation 1.0 28 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

/**
 * @author F. Motte
 *
 */
public interface MetricRuntimeCalculation {

	// ID
	public void setId(String ID);
	
	public String getId();

	//value
	public void setValue(String value);
	
	public String getValue();
}
