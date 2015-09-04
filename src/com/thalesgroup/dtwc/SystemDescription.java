/*
 *		OPTET Factory
 *
 *	Class SystemDescription 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;
import java.util.List;

import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.impl.AssetImpl;
import com.thalesgroup.dtwc.impl.ComponentImpl;
import com.thalesgroup.dtwc.impl.StakeholderImpl;

/**
 * @author F. Motte
 *
 */
public interface SystemDescription {

	// Component
	public Component addComponent(String name);
	
	public void removeComponent(String name);
	
	Collection<ComponentImpl> getComponentList();

	// stakeholder
	public Stakeholder addStakeholder(String name);
	
	public void removeStakeholder(String name);
	
	Collection<StakeholderImpl> getStakeholderList();
	
	// asset
	public Asset addAsset(String name);
	
	public void removeAsset(String asset);
	
	Collection<AssetImpl> getAssetList();
	
	// ID
	public void setId(String ID);
	
	public String getId();
}
