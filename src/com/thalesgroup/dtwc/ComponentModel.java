/*
 *		OPTET Factory
 *
 *	Class ComponentModel 1.0 28 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;
import java.util.List;

import com.thalesgroup.dtwc.impl.AttributeImpl;
import com.thalesgroup.dtwc.impl.ComponentImpl;

/**
 * @author F. Motte
 *
 */
public interface ComponentModel {

	public Attribute addAttribute(String name);
	
	public void removeAttribute(String name);
	
	Collection<AttributeImpl> getAttributeList();
	
	public Component addComponent(String name);
	
	public void removeComponent(String name);
	
	Collection<ComponentImpl> getComponentList();	
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
