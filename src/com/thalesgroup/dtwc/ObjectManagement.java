/*
 *		OPTET Factory
 *
 *	Class ObjectManagement 1.0 6 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import org.protege.owl.codegeneration.WrappedIndividual;

/**
 * @author F. Motte
 *
 */
public interface ObjectManagement {

	public WrappedIndividual getProtegeObject();
	
	public void clear();
	
	// ID
	public void setId(String ID);
	
	public String getId();

}
