/*
 *		OPTET Factory
 *
 *	Class TWProblemDefinition 1.0 27 févr. 2014
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
public interface TWProblemDefinition {

	public Threat addThreat(String name);
	
	public void removeThreat(String name);
	
	Threat getThreat();
	
	public Asset addAsset(String name);
	
	public void removeAsset(String asset);
	
	Asset getAsset();

	/**
	 * 
	 */
	public void clear();
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
