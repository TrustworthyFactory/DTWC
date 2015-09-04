/*
 *		OPTET Factory
 *
 *	Class TWPropertySpecification 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.List;

/**
 * @author F. Motte
 *
 */
public interface TWPropertySpecification {

	
	public Control addControl(String name);
	
	public void removeControl(String name);
	
	Control getControl();
	
	public TWProperty addTWProperty(String name);
	
	public void removeTWProperty(String name);
	
	TWProperty getTWProperty();
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
