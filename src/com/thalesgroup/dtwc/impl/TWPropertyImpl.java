/*
 *		OPTET Factory
 *
 *	Class TWPropertyImpl 1.0 5 mars 2014
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
import com.thalesgroup.dtwc.Context;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.TWAttribute;
import com.thalesgroup.dtwc.TWProperty;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class TWPropertyImpl implements TWProperty, ObjectManagement {

	private MyFactory factory;
	private com.thalesgroup.dtwc.protege.TWProperty twProperty_p;
	private ContextImpl context;
	private AssetImpl asset;
	private TWAttributeImpl twAttribute;
	
	/**
	 * @param twProperty_p
	 * @param factory
	 */
	public TWPropertyImpl(com.thalesgroup.dtwc.protege.TWProperty twProperty_p,
			MyFactory factory) {
		this.factory = factory;
		this.twProperty_p = twProperty_p;
		
		
		
		// check if context already exist
		Collection<? extends WrappedIndividual> contextCol = twProperty_p.getHasContext();
		for (Iterator iterator = contextCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Context context_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Context.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(context_p.getOwlIndividual().toStringID());	
			context = new ContextImpl(context_p, factory);
			break;
		}
		
		// check if asset already exist
		Collection<? extends WrappedIndividual> assetCol = twProperty_p.getHasAsset();
		for (Iterator iterator = assetCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Component asset_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Component.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(asset_p.getOwlIndividual().toStringID());	
			asset = new AssetImpl(asset_p, factory);
			break;
		}
		
		// check if asset already exist
		Collection<? extends WrappedIndividual> twAtrributeCol = twProperty_p.getHasTWAttribute();
		for (Iterator iterator = twAtrributeCol.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.TWAttribute twAtrribute_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.TWAttribute.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(twAtrribute_p.getOwlIndividual().toStringID());	
			twAttribute = new TWAttributeImpl(twAtrribute_p, factory);
			break;
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#addContext(com.thalesgroup.Context)
	 */
	@Override
	public Context addContext(String name) {
		com.thalesgroup.dtwc.protege.Context context_p = factory.createContext(name);
		context_p.addID(name);
		twProperty_p.addHasContext(context_p);
		context = new ContextImpl(context_p, factory);
		return context;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#removeContext(java.lang.String)
	 */
	@Override
	public void removeContext(String name) {
		twProperty_p.removeHasContext(context.getProtegeObject());
		context = null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#getContextList()
	 */
	@Override
	public Context getContext() {
		return context;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#addAsset(com.thalesgroup.Asset)
	 */
	@Override
	public Asset addAsset(String name) {
		com.thalesgroup.dtwc.protege.Component asset_p = factory.getComponent(name);
		asset_p.addID(name);
		twProperty_p.addHasAsset(asset_p);
		asset = new AssetImpl(asset_p, factory);
		return asset;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#removeAsset(java.lang.String)
	 */
	@Override
	public void removeAsset(String name) {
		twProperty_p.removeHasAsset(asset.getProtegeObject());
		asset = null;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#getAssetList()
	 */
	@Override
	public Asset getAsset() {
		// TODO Auto-generated method stub
		return asset;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#addTWAttribute(com.thalesgroup.TWAttribute)
	 */
	@Override
	public TWAttribute addTWAttribute(String name) {
		com.thalesgroup.dtwc.protege.TWAttribute twAttribute_p = factory.createTWAttribute(name);
		twProperty_p.addHasTWAttribute(twAttribute_p);
		twAttribute = new TWAttributeImpl(twAttribute_p, factory);
		return twAttribute;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#removeTWAttribute(java.lang.String)
	 */
	@Override
	public void removeTWAttribute(String name) {
		twProperty_p.removeHasTWAttribute(twAttribute.getProtegeObject());
		twAttribute = null;

	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.TWProperty#getTWAttributeList()
	 */
	@Override
	public TWAttribute getTWAttribute() {
		// TODO Auto-generated method stub
		return twAttribute;
	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return twProperty_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if (context != null){
			context.clear();
		}
		if (asset != null){
			asset.clear();
		}
		if (twAttribute != null){
			twAttribute.clear();
		}
		twProperty_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWProperty#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			twProperty_p.removeID(getId());
		}
		twProperty_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.TWProperty#getId()
	 */
	@Override
	public String getId() {
		if (twProperty_p.hasID()){
			return twProperty_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
