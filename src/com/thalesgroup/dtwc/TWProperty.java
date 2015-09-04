/*
 *		OPTET Factory
 *
 *	Class TWProperty 1.0 28 févr. 2014
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
public interface TWProperty {

	public Context addContext(String name);
	
	public void removeContext(String name);
	
	Context getContext();
	
	public Asset addAsset(String name);
	
	public void removeAsset(String asset);
	
	Asset getAsset();
	
	public TWAttribute addTWAttribute(String name);
	
	public void removeTWAttribute(String name);
	
	TWAttribute getTWAttribute();
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
