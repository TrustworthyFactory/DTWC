/*
 *		OPTET Factory
 *
 *	Class ComponentImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Behaviour;
import com.thalesgroup.dtwc.Component;
import com.thalesgroup.dtwc.ComponentModel;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.protege.DTWC;
import com.thalesgroup.dtwc.protege.MyFactory;
import com.thalesgroup.dtwc.protege.SystemDescription;

/**
 * @author F. Motte
 *
 */
public class ComponentImpl implements Component, ObjectManagement {

	private com.thalesgroup.dtwc.protege.Component component_p;

	private ComponentModel componentModel = null; 
	private MyFactory factory;

	private Map<String, StakeholderImpl> StakeholderMap;
	private Map<String, behaviourImpl> BehaviourMap;
	private String type;
	private Boolean InTargetOfEvaluation = false;



	/**
	 * @param component_p2
	 * @param factory2
	 */
	public ComponentImpl(com.thalesgroup.dtwc.protege.Component component_p,
			MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.component_p = component_p;

		StakeholderMap = new HashMap<>();
		BehaviourMap = new HashMap<>();

		// check if a componentmodel already exist
		Collection<? extends WrappedIndividual> componentModelCol = component_p.getHasPart();
		for (Iterator iterator = componentModelCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.ComponentModel componentModel_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.ComponentModel.class);

			System.out.println(componentModel_p.getOwlIndividual().toStringID());		
			componentModel  = new ComponentModelImpl(componentModel_p, factory);
			break;
		}

		// check if some  Stakeholder already exist		
		Collection<? extends WrappedIndividual> stakeholder = component_p.getHasAssociatedStakeholder();
		for (Iterator iterator = stakeholder.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Stakeholder.class);
			System.out.println(stakeholder_p.getOwlIndividual().toStringID());	
			StakeholderMap.put(stakeholder_p.getOwlIndividual().toStringID(), new StakeholderImpl(stakeholder_p, factory));
		}

		// check if some  behaviour already exist		
		Collection<? extends WrappedIndividual> behaviour = component_p.getHasBehaviour();
		for (Iterator iterator = behaviour.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Behaviour behaviour_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Behaviour.class);
			System.out.println(behaviour_p.getOwlIndividual().toStringID());	
			BehaviourMap.put(behaviour_p.getOwlIndividual().toStringID(), new behaviourImpl(behaviour_p, factory));
		}	
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#getComponentModel()
	 */
	@Override
	public ComponentModel getComponentModel() {
		if (componentModel == null){
			com.thalesgroup.dtwc.protege.ComponentModel componentModel_p = factory.createComponentModel(component_p.getOwlIndividual().toStringID() + "ComponentName");
			component_p.addHasPart(componentModel_p);
			componentModel  = new ComponentModelImpl(componentModel_p, factory);
		}
		return componentModel;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#addStakeholder(java.lang.String)
	 */
	@Override
	public Stakeholder addStakeholder(String name) {
		com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p = factory.createStakeholder(name);
		component_p.addHasAssociatedStakeholder(stakeholder_p);		
		StakeholderImpl stakeholer = new StakeholderImpl(stakeholder_p, factory);
		StakeholderMap.put(name, stakeholer);
		return stakeholer;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#removeStakeholder(java.lang.String)
	 */
	@Override
	public void removeStakeholder(String name) {
		component_p.removeHasAssociatedStakeholder(StakeholderMap.get(name).getProtegeObject());
		StakeholderMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#getStakeholderList()
	 */
	@Override
	public Collection<StakeholderImpl> getStakeholderList() {
		return StakeholderMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#addBehaviour(java.lang.String)
	 */
	@Override
	public Behaviour addBehaviour(String name) {
		com.thalesgroup.dtwc.protege.Behaviour behaviour_p = factory.createBehaviour(name);
		component_p.addHasBehaviour(behaviour_p);		

		behaviourImpl behaviour = new behaviourImpl(behaviour_p, factory);
		BehaviourMap.put(name, behaviour);
		return behaviour;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#removeBehaviour(java.lang.String)
	 */
	@Override
	public void removeBehaviour(String name) {
		component_p.removeHasBehaviour(BehaviourMap.get(name).getProtegeObject());
		BehaviourMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#getBehaviourList()
	 */
	@Override
	public Collection<behaviourImpl> getBehaviourList() {
		return BehaviourMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.Component#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		if (getType()!=null){
			component_p.removeType(getType());
		}
		this.type = type;
		component_p.addType(type);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Component#getType()
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		
		if (component_p.hasType()){
			return component_p.getType().iterator().next();
		}else { 
			return null;
		}
	}
	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		System.out.println(component_p.getOwlIndividual().toStringID());
		return component_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

		Set<String> keys = StakeholderMap.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			component_p.removeHasAssociatedStakeholder(StakeholderMap.get(string).getProtegeObject());
			StakeholderImpl value = StakeholderMap.get(string);
			value.clear();
		}
		StakeholderMap.clear();
		Set<String> keys2 = BehaviourMap.keySet();
		for (Iterator iterator = keys2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			component_p.removeHasBehaviour(BehaviourMap.get(string).getProtegeObject());
			behaviourImpl value = BehaviourMap.get(string);
			value.clear();
		}
		BehaviourMap.clear();
		component_p.delete();

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Component#setInTargetOfEvaluation(boolean)
	 */
	@Override
	public void setInTargetOfEvaluation(boolean toe) {
		// TODO Auto-generated method stub
	
		if (getId()!=null){
			component_p.removeInTargetOfEvaluation(getIntargetOfEvaluation());
		}
		component_p.addInTargetOfEvaluation(toe);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Component#getIntargetOfEvaluation()
	 */
	@Override
	public boolean getIntargetOfEvaluation() {
		
		// TODO Auto-generated method stub
		if (component_p.hasInTargetOfEvaluation()){
			return component_p.getInTargetOfEvaluation().iterator().next();
		}else { 
			return false;
		}
	}



	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Component#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			component_p.removeID(getId());
		}
		component_p.addID(ID);

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Component#getId()
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		if (component_p.hasID()){
			return component_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
