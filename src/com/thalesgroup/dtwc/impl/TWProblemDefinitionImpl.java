/*
 *		OPTET Factory
 *
 *	Class TWProblemDefinitionImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Asset;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.TWProblemDefinition;
import com.thalesgroup.dtwc.Threat;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class TWProblemDefinitionImpl implements TWProblemDefinition, ObjectManagement {

	private com.thalesgroup.dtwc.protege.TWProblemDefinition problemDef_p;
	private MyFactory factory;
	
	private AssetImpl asset = null;
	
	private ThreatImpl threat = null;
	/**
	 * @param problemDef_p
	 * @param factory 
	 */
	protected TWProblemDefinitionImpl(com.thalesgroup.dtwc.protege.TWProblemDefinition problemDef_p, MyFactory factory) {
		this.problemDef_p = problemDef_p;
		this.factory = factory;
		
		
		// check if threat already exist
		Collection<? extends WrappedIndividual> threatCol = problemDef_p.getHasThreat();
		for (Iterator iterator = threatCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Threat threat_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Threat.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(threat_p.getOwlIndividual().toStringID());	
			threat = new ThreatImpl(threat_p, factory);
			break;
		}
		
		// check if asset already exist
		Collection<? extends WrappedIndividual> assetCol = problemDef_p.getAffectsAsset();
		for (Iterator iterator = assetCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Component asset_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Component.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(asset_p.getOwlIndividual().toStringID());	
			asset = new AssetImpl(asset_p, factory);
			break;
		}
		
	}

	public com.thalesgroup.dtwc.protege.TWProblemDefinition getProtegeObject(){
		return problemDef_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#addThreat(com.thalesgroup.Threat)
	 */
	@Override
	public Threat addThreat(String name) {
		com.thalesgroup.dtwc.protege.Threat threat_p = factory.createThreat(name);
		threat_p.addID(name);
		problemDef_p.addHasThreat(threat_p);
		threat = new ThreatImpl(threat_p, factory);
		return threat;
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#removeThreat(java.lang.String)
	 */
	@Override
	public void removeThreat(String name) {
		problemDef_p.removeHasThreat(threat.getProtegeObject());
		threat = null;
		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#getThreat()
	 */
	@Override
	public Threat getThreat() {
		// TODO Auto-generated method stub
		return threat;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#addAsset(com.thalesgroup.Asset)
	 */
	@Override
	public Asset addAsset(String name) {
		com.thalesgroup.dtwc.protege.Component asset_p = factory.getComponent(name);
		asset_p.addID(name);
		problemDef_p.addAffectsAsset(asset_p);
		asset = new AssetImpl(asset_p, factory);
		return asset;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#removeAsset(java.lang.String)
	 */
	@Override
	public void removeAsset(String name) {
		problemDef_p.removeAffectsAsset(asset.getProtegeObject());
		asset = null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#getAsset()
	 */
	@Override
	public Asset getAsset() {
		// TODO Auto-generated method stub
		return asset;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProblemDefinition#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if (asset != null){
			asset.clear();
		}
		if (threat != null){
			threat.clear();
		}
		problemDef_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWProblemDefinition#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			problemDef_p.removeID(getId());
		}
		problemDef_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWProblemDefinition#getId()
	 */
	@Override
	public String getId() {
		if (problemDef_p.hasID()){
			return problemDef_p.getID().iterator().next();
		}else { 
			return null;
		}
	}
	


}
