/*
 *		OPTET Factory
 *
 *	Class AssetImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Asset;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.protege.MyFactory;
import com.thalesgroup.dtwc.protege.SystemDescription;

/**
 * @author F. Motte
 *
 */
public class AssetImpl implements Asset, ObjectManagement {

	private MyFactory factory;
	private com.thalesgroup.dtwc.protege.Component asset_p;

	/**
	 * @param asset_p2
	 * @param factory2
	 */
	public AssetImpl(com.thalesgroup.dtwc.protege.Component asset_p, MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.asset_p = asset_p;
 	}

	/**
	 * @return
	 */
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return asset_p;
	}

	/**
	 * 
	 */
	public void clear() {
		// TODO Auto-generated method stub
		//asset_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Asset#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			asset_p.removeID(getId());
		}
		asset_p.addID(ID);

		
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.Asset#getId()
	 */
	@Override
	public String getId() {
		if (asset_p.hasID()){
			return asset_p.getID().iterator().next();
		}else { 
			return null;
		}
	}

}
