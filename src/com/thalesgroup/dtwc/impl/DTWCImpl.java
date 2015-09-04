/*
 *		OPTET Factory
 *
 *	Class DTWCImpl 1.0 28 févr. 2014
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
import java.util.Map.Entry;
import java.util.Set;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.DTWC;
import com.thalesgroup.dtwc.Evidence;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.SystemDescription;
import com.thalesgroup.dtwc.TWProblemDefinition;
import com.thalesgroup.dtwc.TWPropertySpecification;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class DTWCImpl implements DTWC, ObjectManagement {

	private SystemDescription systemDescription = null;

	private Map<String, TWProblemDefinitionImpl> TWProblemDefinitionMap;

	private Map<String, TWPropertySpecificationImpl> TWPropertySpecificationMap;

	private Map<String, EvidenceImpl> EvidenceMap;

	private com.thalesgroup.dtwc.protege.DTWC dtwc_p;

	private MyFactory factory;

	/**
	 * @param dtwc_p
	 * @param factory 
	 */
	protected DTWCImpl(com.thalesgroup.dtwc.protege.DTWC dtwc_p, MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.dtwc_p = dtwc_p;		
		TWProblemDefinitionMap = new HashMap<String, TWProblemDefinitionImpl>();
		TWPropertySpecificationMap = new HashMap<String, TWPropertySpecificationImpl>();
		EvidenceMap = new HashMap<String, EvidenceImpl>();
		this.factory = factory;

		// check if a systemdescription already exist
		Collection<? extends WrappedIndividual> systemDesc = dtwc_p.getHasPart();
		for (Iterator iterator = systemDesc.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.SystemDescription systemDescription_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.SystemDescription.class);

			System.out.println(systemDescription_p.getOwlIndividual().toStringID());		
			systemDescription  = new SystemDescriptionImpl(systemDescription_p, factory);
			break;
		}

		// check if some  TWProblemDefinition already exist		
		Collection<? extends WrappedIndividual> problemDef = dtwc_p.getHasTWProblemDefinition();
		for (Iterator iterator = problemDef.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.TWProblemDefinition problemDef_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.TWProblemDefinition.class);
			//dtwc_p.addHasTWProblemDefinition(problemDef_p);
			System.out.println(problemDef_p.getOwlIndividual().toStringID());	
			TWProblemDefinitionMap.put(problemDef_p.getOwlIndividual().toStringID(), new TWProblemDefinitionImpl(problemDef_p, factory));
		}

		// check if some  TWPropertySpecification already exist		
		Collection<? extends WrappedIndividual> problemSpec = dtwc_p.getHasTWPropertySpecification();
		for (Iterator iterator = problemSpec.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.TWPropertySpecification problemSpec_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.TWPropertySpecification.class);
			//dtwc_p.addHasTWPropertySpecification(problemSpec_p);
			System.out.println(problemSpec_p.getOwlIndividual().toStringID());	
			TWPropertySpecificationMap.put(problemSpec_p.getOwlIndividual().toStringID(), new TWPropertySpecificationImpl(problemSpec_p, factory));
		}
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#getSystemDescription()
	 */
	@Override
	public SystemDescription getSystemDescription() {
		if (systemDescription == null){
			com.thalesgroup.dtwc.protege.SystemDescription systemDescription_p = factory.createSystemDescription("SystemDescription");
			dtwc_p.addHasPart(systemDescription_p);
			systemDescription  = new SystemDescriptionImpl(systemDescription_p, factory);
		}
		return systemDescription;
	}



	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#addTWProblemDefinition()
	 */
	@Override
	public TWProblemDefinition addTWProblemDefinition(String name) {
		// TODO Auto-generated method stub
		com.thalesgroup.dtwc.protege.TWProblemDefinition twpd_p = factory.createTWProblemDefinition(name);
		twpd_p.addID(name);
		dtwc_p.addHasTWProblemDefinition(twpd_p);
		TWProblemDefinitionImpl twpd = new TWProblemDefinitionImpl(twpd_p, factory);
		TWProblemDefinitionMap.put(name, twpd);
		return twpd;
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#deleteTWProblemDefinition(com.thalesgroup.TWProblemDefinition)
	 */
	@Override
	public void deleteTWProblemDefinition(String name) {
		// TODO Auto-generated method stub		
		dtwc_p.removeHasTWProblemDefinition(TWProblemDefinitionMap.get(name).getProtegeObject());
		TWProblemDefinition twPD = TWProblemDefinitionMap.remove(name);
		twPD.clear();
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#getTWProblemDefinitions()
	 */
	@Override
	public Collection<TWProblemDefinitionImpl> getTWProblemDefinitions() {
		// TODO Auto-generated method stub
		return TWProblemDefinitionMap.values();
	}

	public Set<String> getTWProblemDefinitionsKey() {
		//Iterator<String> it = TWProblemDefinitionMap.keySet().iterator();

	    for(Iterator<Entry<String, TWProblemDefinitionImpl>> it = TWProblemDefinitionMap.entrySet().iterator(); it.hasNext(); ) {
	        Entry<String, TWProblemDefinitionImpl> entry = it.next();
	        dtwc_p.removeHasTWProblemDefinition(TWProblemDefinitionMap.get(entry.getKey()).getProtegeObject());
	        entry.getValue().clear();
	      }
	    TWProblemDefinitionMap.clear();
		return null;
	}
	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#addTWPropertySpecification()
	 */
	@Override
	public TWPropertySpecification addTWPropertySpecification(String name) {
		// TODO Auto-generated method stub
		com.thalesgroup.dtwc.protege.TWPropertySpecification twps_p = factory.createTWPropertySpecification(name);
		twps_p.addID(name);
		dtwc_p.addHasTWPropertySpecification(twps_p);
		TWPropertySpecificationImpl twps = new TWPropertySpecificationImpl(twps_p, factory);
		TWPropertySpecificationMap.put(name, twps);
		return twps;
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#deleteTWPropertySpecification(com.thalesgroup.TWPropertySpecification)
	 */
	@Override
	public void deleteTWPropertySpecification(String name) {
		dtwc_p.removeHasTWPropertySpecification(TWPropertySpecificationMap.get(name).getProtegeObject());
		TWPropertySpecificationMap.remove(name);
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#getTWPropertySpecifications()
	 */
	@Override
	public Collection<TWPropertySpecificationImpl> getTWPropertySpecifications() {
		// TODO Auto-generated method stub
		return TWPropertySpecificationMap.values();
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#addCertifiedEvidence()
	 */
	@Override
	public Evidence addCertifiedEvidence(String name) {
		com.thalesgroup.dtwc.protege.CertifiedEvidence ev_p = factory.createCertifiedEvidence(name);
		ev_p.addID(name);
		dtwc_p.addHasEvidence(ev_p);
		EvidenceImpl ev = new EvidenceImpl(ev_p, factory);
		EvidenceMap.put(name, ev);
		return ev;
	}

	
	
	public Evidence getEvidence(String name) {
		return EvidenceMap.get(name);
	}
	
	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#addRuntimeEvidence(java.lang.String)
	 */
	@Override
	public Evidence addRuntimeEvidence(String name) {
		com.thalesgroup.dtwc.protege.RuntimeEvidence ev_p = factory.createRuntimeEvidence(name);
		ev_p.addID(name);
		dtwc_p.addHasEvidence(ev_p);
		EvidenceImpl ev = new EvidenceImpl(ev_p, factory);
		EvidenceMap.put(name, ev);
		return ev;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#deleteEvidence(com.thalesgroup.Evidence)
	 */
	@Override
	public void deleteEvidence(String name) {
		dtwc_p.removeHasEvidence(EvidenceMap.get(name).getProtegeObject());
		EvidenceMap.remove(name);		
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.DTWC#getEvidence()
	 */
	@Override
	public Collection<EvidenceImpl> getEvidences() {
		return EvidenceMap.values(); 
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#getProtegeObject()
	 */
	@Override
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return dtwc_p;
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		Set<String> keys = TWProblemDefinitionMap.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dtwc_p.removeHasTWProblemDefinition(TWProblemDefinitionMap.get(string).getProtegeObject());
			TWProblemDefinitionImpl value = TWProblemDefinitionMap.get(string);
			value.clear();
		}
		TWProblemDefinitionMap.clear();
		
		Set<String> keys2 = TWPropertySpecificationMap.keySet();
		for (Iterator iterator = keys2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dtwc_p.removeHasTWPropertySpecification(TWPropertySpecificationMap.get(string).getProtegeObject());
			TWPropertySpecificationImpl value = TWPropertySpecificationMap.get(string);
		    value.clear();
		}
		TWPropertySpecificationMap.clear();
		
		Set<String> keys3 = EvidenceMap.keySet();
		for (Iterator iterator = keys3.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			dtwc_p.removeHasEvidence(EvidenceMap.get(string).getProtegeObject());
			EvidenceImpl value = EvidenceMap.get(string);
		    value.clear();
		}
		EvidenceMap.clear();
		dtwc_p.delete();
		
		
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.DTWC#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			dtwc_p.removeID(getId());
		}
		dtwc_p.addID(ID);
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.DTWC#getId()
	 */
	@Override
	public String getId() {
		if (dtwc_p.hasID()){
			return dtwc_p.getID().iterator().next();
		}else { 
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.DTWC#setHash(java.lang.String)
	 */
	@Override
	public void setHash(String hash) {
		// TODO Auto-generated method stub
		if (getHash()!=null){
			dtwc_p.removeHasHash(getHash());
		}
		dtwc_p.addHasHash(hash);
	}


	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.DTWC#getHash()
	 */
	@Override
	public String getHash() {
		if (dtwc_p.hasHasHash()){
			return (String) dtwc_p.getHasHash().iterator().next();
		}else { 
			return null;
		}
	}



}
