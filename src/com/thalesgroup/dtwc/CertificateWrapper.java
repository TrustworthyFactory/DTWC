/*
 *		OPTET Factory
 *
 *	Class Certificatewrapper 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc;

import java.io.IOException;

import org.semanticweb.owlapi.model.OWLOntologyStorageException;


/**
 * @author F. Motte
 *
 */
public interface CertificateWrapper {

	/**
	 * create a DTWC data model from a file
	 * @param name
	 * @param path
	 * @return
	 */
	public DTWC createCertificate(String name, String path);
	
	/**
	 * load a DTWC data model from a file
	 * @param name
	 * @param path
	 * @return
	 */
	public DTWC loadCertificate(String name, String path);
	
	/**
	 * delete a DTWC data model
	 * @param name
	 */
	public void removeCertificate(String name);

	/**
	 * print a certificate in a Turtle format
	 * @param path
	 * @throws IOException
	 * @throws OWLOntologyStorageException
	 */
	public void printCertificate(String path) throws IOException, OWLOntologyStorageException;
	
	/**
	 * print a certificate in a XML format
	 * @param path
	 * @throws IOException
	 * @throws OWLOntologyStorageException
	 */
	public void printXMLCertificate(String path) throws IOException, OWLOntologyStorageException;	
}
