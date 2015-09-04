/*
 *		OPTET Factory
 *
 *	Class Stakeholder 1.0 27 févr. 2014
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
public interface Stakeholder {

	// ID
	public void setId(String ID);
	
	public String getId();

	// type
	public void setType(String type);

	public String getType();
}
