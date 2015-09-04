/*
 *		OPTET Factory
 *
 *	Class SystemDescriptionImpl 1.0 28 févr. 2014
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

import com.thalesgroup.dtwc.Asset;
import com.thalesgroup.dtwc.Component;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.SystemDescription;
import com.thalesgroup.dtwc.protege.DTWC;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class SystemDescriptionImpl implements SystemDescription, ObjectManagement {

	private com.thalesgroup.dtwc.protege.SystemDescription systemDescription_p;
	
	
	private Map<String, ComponentImpl> componentMap;
	private Map<String, StakeholderImpl> stakeholderMap;
	private Map<String, AssetImpl> assetMap;
	private MyFactory factory;





	/**
	 * @param sd
	 * @param factory2
	 */
	public SystemDescriptionImpl(com.thalesgroup.dtwc.protege.SystemDescription sd,
			MyFactory factory) {
		this.factory = factory;

		systemDescription_p = sd;		
		componentMap = new HashMap<String, ComponentImpl>();
		stakeholderMap = new HashMap<String, StakeholderImpl>();
		assetMap = new HashMap<String, AssetImpl>();
		
		
		// check if a Component already exist
		Collection<? extends WrappedIndividual> component = systemDescription_p.getHasPart();
		for (Iterator iterator = component.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Component component_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Component.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(component_p.getOwlIndividual().toStringID());	
			componentMap.put(component_p.getOwlIndividual().toStringID(), new ComponentImpl(component_p, factory));
		}
		
		// check if some  stakeholder already exist		
		Collection<? extends WrappedIndividual> stakeholder = systemDescription_p.getHasStakeholder();
		for (Iterator iterator = stakeholder.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Stakeholder.class);
			//systemDescription_p.addHasStakeholder(stakeholder_p);
			System.out.println(stakeholder_p.getOwlIndividual().toStringID());	
			stakeholderMap.put(stakeholder_p.getOwlIndividual().toStringID(), new StakeholderImpl(stakeholder_p, factory));
		}
		
		// check if some  asset already exist		
		Collection<? extends WrappedIndividual> asset = systemDescription_p.getHasAsset();
		for (Iterator iterator = asset.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Component asset_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Component.class);
			//systemDescription_p.addHasAsset(asset_p);
			System.out.println(asset_p.getOwlIndividual().toStringID());	
			assetMap.put(asset_p.getOwlIndividual().toStringID(), new AssetImpl(asset_p, factory));
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#addComponent(java.lang.String)
	 */
	@Override
	public Component addComponent(String name) {
		com.thalesgroup.dtwc.protege.Component component_p = factory.createComponent(name);
		component_p.addID(name);
		systemDescription_p.addHasPart(component_p);		
		ComponentImpl comp = new ComponentImpl(component_p, factory);
		componentMap.put(name, comp);
		return comp;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#removeComponent(java.lang.String)
	 */
	@Override
	public void removeComponent(String name) {
		System.out.println("remove comp " + name);
		systemDescription_p.removeHasPart(componentMap.get(name).getProtegeObject());
		ComponentImpl comp = componentMap.remove(name);
		comp.clear();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#getComponentList()
	 */
	@Override
	public Collection<ComponentImpl> getComponentList() {
		return componentMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#addStakeholder(java.lang.String)
	 */
	@Override
	public Stakeholder addStakeholder(String name) {
		com.thalesgroup.dtwc.protege.Stakeholder stakeholder_p = factory.createStakeholder(name);
		stakeholder_p.addID(name);
		systemDescription_p.addHasStakeholder(stakeholder_p);		
		StakeholderImpl stakeholer = new StakeholderImpl(stakeholder_p, factory);
		stakeholderMap.put(name, stakeholer);
		return stakeholer;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#removeStakeholder(java.lang.String)
	 */
	@Override
	public void removeStakeholder(String name) {
		systemDescription_p.removeHasStakeholder(stakeholderMap.get(name).getProtegeObject());
		stakeholderMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#getStakeholderList()
	 */
	@Override
	public Collection<StakeholderImpl> getStakeholderList() {
		return stakeholderMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#addAsset(java.lang.String)
	 */
	@Override
	public Asset addAsset(String name) {
		
		com.thalesgroup.dtwc.protege.Component comp_p = factory.getComponent(name);
		systemDescription_p.addHasAsset(comp_p);
		AssetImpl asset = new AssetImpl(comp_p, factory);
		
//		com.thalesgroup.dtwc.protege.Asset asset_p = factory.createAsset(name);
//		systemDescription_p.addHasAsset(asset_p);		
//		AssetImpl asset = new AssetImpl(asset_p, factory);
		assetMap.put(name, asset);
		return asset;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#removeAsset(java.lang.String)
	 */
	@Override
	public void removeAsset(String name) {
		systemDescription_p.removeHasAsset(assetMap.get(name).getProtegeObject());
		assetMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.SystemDescription#getAssetList()
	 */
	@Override
	public Collection<AssetImpl> getAssetList() {
		return assetMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#getProtegeObject()
	 */
	@Override
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return systemDescription_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Set<String> keys = componentMap.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			systemDescription_p.removeHasPart(componentMap.get(string).getProtegeObject());
			ComponentImpl value = componentMap.get(string);
			value.clear();
		}
		componentMap.clear();
		
		Set<String> keys2 = stakeholderMap.keySet();
		for (Iterator iterator = keys2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			systemDescription_p.removeHasStakeholder(stakeholderMap.get(string).getProtegeObject());
			StakeholderImpl value = stakeholderMap.get(string);
			value.clear();
		}
		stakeholderMap.clear();
		
		Set<String> keys3 = assetMap.keySet();
		for (Iterator iterator = keys3.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			systemDescription_p.removeHasAsset(assetMap.get(string).getProtegeObject());
			AssetImpl value = assetMap.get(string);
			value.clear();
		}
		assetMap.clear();
		systemDescription_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.SystemDescription#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			systemDescription_p.removeID(getId());
		}
		systemDescription_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.SystemDescription#getId()
	 */
	@Override
	public String getId() {
		if (systemDescription_p.hasID()){
			return systemDescription_p.getID().iterator().next();
		}else { 
			return null;
		}
	}
}
