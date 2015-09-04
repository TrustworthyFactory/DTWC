/*
 *		OPTET Factory
 *
 *	Class Component 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;
import java.util.List;

import com.thalesgroup.dtwc.impl.StakeholderImpl;
import com.thalesgroup.dtwc.impl.behaviourImpl;

/**
 * @author F. Motte
 *
 */
public interface Component {

	// Component model
	public ComponentModel getComponentModel();
	
	// stakeholder

	public Stakeholder addStakeholder(String name);
	
	public void removeStakeholder(String name);
	
	Collection<StakeholderImpl> getStakeholderList();
	
	// Behaviour
	public Behaviour addBehaviour(String name);
	
	public void removeBehaviour(String name);
	
	Collection<behaviourImpl> getBehaviourList();
	
	// type
	public void setType(String type);

	public String getType();

	// inTargetOfEvaluation
	public void setInTargetOfEvaluation(boolean toe);
	
	public boolean getIntargetOfEvaluation();
	
	// ID
	public void setId(String ID);
	
	public String getId();
}
