/*
 *		OPTET Factory
 *
 *	Class DTWC 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.thalesgroup.dtwc.impl.EvidenceImpl;
import com.thalesgroup.dtwc.impl.TWProblemDefinitionImpl;
import com.thalesgroup.dtwc.impl.TWPropertySpecificationImpl;

/**
 * @author F. Motte
 *
 */
public interface DTWC {

	// system management
	public SystemDescription getSystemDescription();
	
	// TWProblemDefinitions
	public TWProblemDefinition addTWProblemDefinition(String name);
	
	public void deleteTWProblemDefinition(String name);
	
	public Collection<TWProblemDefinitionImpl> getTWProblemDefinitions();
	
	public Set<String> getTWProblemDefinitionsKey();
	
	// TWPropertySpecifications
	public TWPropertySpecification addTWPropertySpecification(String name);
	
	public void deleteTWPropertySpecification(String name);
	
	public Collection<TWPropertySpecificationImpl> getTWPropertySpecifications();
	
	// Evidences
	public Evidence addCertifiedEvidence(String name);
	
	public Evidence addRuntimeEvidence(String name);
	
	public void deleteEvidence(String name);
	
	public Collection<EvidenceImpl> getEvidences();
	
	public Evidence getEvidence(String name);

	// ID
	public void setId(String ID);
	
	public String getId();

	// ID
	public void setHash(String hash);
	
	public String getHash();

}
