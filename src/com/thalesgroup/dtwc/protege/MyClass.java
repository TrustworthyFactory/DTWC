/*
 *		OPTET Factory
 *
 *	Class MyClass 1.0 27 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.protege;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;

import org.coode.owlapi.turtle.TurtleOntologyFormat;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

/**
 * @author F. Motte
 *
 */
public class MyClass {

	public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        


        File f = new File("D:/temp/protege/dtwc.ttl");
        OWLOntology MyOntology = manager.loadOntologyFromOntologyDocument(f);
		MyFactory factory = new MyFactory(MyOntology);
		
		
		System.out.println("test");
		DTWC dtwc = factory.createDTWC("MyDTWC");
		SystemDescription sd = factory.createSystemDescription("MySystem");
		Evidence e = factory.createEvidence("MyEvidence");
		System.out.println("test");
		dtwc.addHasEvidence(e);
		System.out.println("test");
		dtwc.addHasPart(sd);
		System.out.println("test");
		factory.saveOwlOntology();
		System.out.println("test");
		
		
		TWProblemDefinition prob1 = factory.createTWProblemDefinition("prob1");
		Asset asset = factory.createAsset("myAsset");
		Threat threat = factory.createThreat("MyThreat");
		
		prob1.addAffectsAsset(asset);
		prob1.addHasThreat(threat);
		
		TWProblemDefinition prob2 = factory.createTWProblemDefinition("prob2");
		prob2.addAffectsAsset(asset);
		prob2.addHasThreat(threat);

		dtwc.addHasTWProblemDefinition(prob1);
		dtwc.addHasTWProblemDefinition(prob2);
		
		
		
		
		
		TWPropertySpecification spec1 = factory.createTWPropertySpecification("spec1");
		TWPropertySpecification spec2 = factory.createTWPropertySpecification("spec2");
		
		Control cont1 = factory.createControl("Mycontrol1");
		Control cont2 = factory.createControl("Mycontrol2");
		
		
		TWProperty prop1 = factory.createTWProperty("Myprop1");
		TWProperty prop2 = factory.createTWProperty("Myprop2");
		
		
		spec1.addHasControl(cont1);
		spec2.addHasControl(cont2);
		
		spec1.addHasTWProperty(prop1);
		spec2.addHasTWProperty(prop2);
		
		dtwc.addHasTWPropertySpecification(spec1);
		dtwc.addHasTWPropertySpecification(spec2);
		
		TurtleOntologyFormat turtleFormat = new TurtleOntologyFormat();

		Path testFile = Files.createTempFile("prov", ".ttl");
		try (OutputStream outputStream = Files.newOutputStream(testFile)) {
			System.out.println("test1");
			manager.saveOntology(MyOntology, turtleFormat,	
			outputStream);
			System.out.println("test2");
			}
		System.out.println(testFile);
		
		Path testFile2 = Files.createTempFile("prov", ".xml");
		
		RDFXMLOntologyFormat rdfFormat = new RDFXMLOntologyFormat();
		try (OutputStream outputStream = Files.newOutputStream(testFile2)) {
			System.out.println("test1");
			manager.saveOntology(MyOntology, rdfFormat,	
			outputStream);
			System.out.println("test2");
			}
		
		System.out.println(testFile2);

		
		
		
		Collection<? extends WrappedIndividual> es = dtwc.getHasEvidence();
		System.out.println(es.size());
		for (Iterator iterator = es.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			System.out.println(wrappedIndividual.toString());
			
			
			System.out.println("casAs" + factory.canAs(wrappedIndividual, Evidence.class));
			
			Evidence ev = factory.as(wrappedIndividual, Evidence.class);
			System.out.println(ev.getOwlIndividual().toStringID());
			
		}
	}
	
	
}
