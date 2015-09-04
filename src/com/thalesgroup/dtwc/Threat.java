/*
 *		OPTET Factory
 *
 *	Class Threat 1.0 28 févr. 2014
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
public interface Threat {
	
	public Control addControl(String name);
	
	public void removeControl(String name);
	
	Control getControl();

	public void setType(String type);
	
	public String getType();
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
