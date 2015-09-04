/*
 *		OPTET Factory
 *
 *	Class CertificateWrapper 1.0 28 févr. 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

import org.coode.owlapi.turtle.TurtleOntologyFormat;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import com.thalesgroup.dtwc.Asset;
import com.thalesgroup.dtwc.Behaviour;
import com.thalesgroup.dtwc.Component;
import com.thalesgroup.dtwc.Control;
import com.thalesgroup.dtwc.DTWC;
import com.thalesgroup.dtwc.Evidence;
import com.thalesgroup.dtwc.Metric;
import com.thalesgroup.dtwc.MetricRuntimeCalculation;
import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.SystemDescription;
import com.thalesgroup.dtwc.TWProblemDefinition;
import com.thalesgroup.dtwc.Threat;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class CertificateWrapper implements com.thalesgroup.dtwc.CertificateWrapper {

	private 	OWLOntology MyOntology;
	private 	DTWC dtwc;
	
	public static void main(String[] args) {
        
		CertificateWrapper cw = new CertificateWrapper();
		DTWC dtwc = cw.createCertificate("MyDTWC", "D:/temp/protege/dtwc.ttl");
		
		
		System.out.println("getSystemDescription");
		SystemDescription sd = dtwc.getSystemDescription();
		
		Component comp1 = sd.addComponent("MyComp1");
		Component comp2 = sd.addComponent("MyComp2");
		
		Stakeholder stake1 = sd.addStakeholder("MyStake1");
		Stakeholder stake2 = sd.addStakeholder("MyStake2");
		
		Asset asset1 = sd.addAsset("MyComp1");
		Asset asset2 = sd.addAsset("MyComp2");
		
		Behaviour be1 = comp1.addBehaviour("MyBehaviour1");
		Behaviour be2 = comp1.addBehaviour("MyBehaviour2");
		
		Stakeholder stake = comp1.addStakeholder("MyStake1");
		stake.setId("MyStake1");
		stake.setType("MyStakeType");
		
		Component comp3 = comp1.getComponentModel().addComponent("MyComp3");
		comp1.getComponentModel().addAttribute("MyAttr1");
		comp1.getComponentModel().removeAttribute("MyAttr1");
		comp3.getComponentModel().addComponent("comp4");
		
		System.out.println("comp1.getType()" + comp1.getType());
		comp1.setType("MyType");
		System.out.println("comp1.getType()" + comp1.getType());
		comp1.setType("MyType2");
		System.out.println("comp1.getType()" + comp1.getType());
		comp1.setType("MyType1");
		comp1.setType("MyType6");
		comp1.setType("MyType4");
		comp1.setType("MyType5");
		System.out.println("comp1.getType()" + comp1.getType());
	
		
		comp1.setInTargetOfEvaluation(true);
		comp1.setInTargetOfEvaluation(false);
		comp1.setInTargetOfEvaluation(false);
		comp1.setInTargetOfEvaluation(true);
		System.out.println("in TOE" + comp1.getIntargetOfEvaluation());
		
		
		//sd.removeComponent("MyComp1");
		
		TWProblemDefinition prob1 = dtwc.addTWProblemDefinition("MyProb1");
		Threat threat1 = prob1.addThreat("MyThreat1");
		Control control1 = threat1.addControl("MyControl1");
		Asset asset12 = prob1.addAsset("MyComp1");
		TWProblemDefinition prob2 = dtwc.addTWProblemDefinition("MyProb2");
		Threat threat2 = prob2.addThreat("MyThreat2");
		Asset asset22 = prob2.addAsset("MyComp1");
		Control control2 = threat2.addControl("MyControl2");	
		
		
		Collection<TWProblemDefinitionImpl> col = dtwc.getTWProblemDefinitions();
		for (Iterator iterator = col.iterator(); iterator.hasNext();) {
			TWProblemDefinitionImpl twProblemDefinitionImpl = (TWProblemDefinitionImpl) iterator
					.next();
			System.out.println("twProblemDefinitionImpl " + twProblemDefinitionImpl.getId());
			
		}
		
		Evidence ev1 = dtwc.addCertifiedEvidence("MyCertEvidence");
		Metric m1 = ev1.addMetric("MyMetric1");
		m1.setValue("myValue1");
		m1.setUnit("MyUnit1");
		MetricRuntimeCalculation mrc = m1.addMetricRuntimeCalculation("mrc");
		mrc.setId("mrcID1");
		mrc.setValue("mrcValue");
		Metric m2 = ev1.addMetric("MyMetric2");
		m2.setValue("myValue2");
		m2.setUnit("MyUnit2");
		
	
		
		try {
			cw.printCertificate("file:/D:/temp/temp.ttl");
		} catch (OWLOntologyStorageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CertificateWrapper cw2 = new CertificateWrapper();
		DTWC dtwc2 = cw2.loadCertificate("MyDTWC", "D:/temp/temp.ttl");
		
		System.out.println("eeeeeeeeeeeeeee");
		
		Collection<EvidenceImpl> evidences = dtwc2.getEvidences();
		for (Iterator iterator = evidences.iterator(); iterator.hasNext();) {
			EvidenceImpl evidenceImpl = (EvidenceImpl) iterator.next();
			System.out.println("evidence " + evidenceImpl.getId()) ;
			Collection<MetricImpl> metrics = evidenceImpl.getMetricList();
			for (Iterator iterator2 = metrics.iterator(); iterator2.hasNext();) {
				MetricImpl metricImpl = (MetricImpl) iterator2.next();
				System.out.println("metric ID" + metricImpl.getId());
				System.out.println("metric value" + metricImpl.getValue());
				System.out.println("metric type" + metricImpl.getType());
				Collection<MetricRuntimeCalculationImpl> mrcs = metricImpl.getMetricRuntimeCalculationList();
				for (Iterator iterator3 = mrcs.iterator(); iterator3.hasNext();) {
					MetricRuntimeCalculationImpl metricRuntimeCalculationImpl = (MetricRuntimeCalculationImpl) iterator3
							.next();
					System.out.println("mrc " + metricRuntimeCalculationImpl.getValue());
				}
			}
		}
		
//		//dtwc2.getSystemDescription().removeComponent("MyComp1");
//		
//		
//		//dtwc2.deleteTWProblemDefinition("MyProb1");
//		
//		try {
//			cw2.printCertificate("file:/D:/temp/temp2.ttl");
//		} catch (OWLOntologyStorageException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		CertificateWrapper cw3 = new CertificateWrapper();
//		DTWC dtwc3 = cw3.loadCertificate("test", "D:/works/security2011/optet/wp3/dtwc-Ambulance_Service_3.xml");
//		
//		System.out.println(dtwc3.getSystemDescription().getId());
//		
//		try {
//			cw3.printCertificate("file:/D:/temp/temp2.ttl");
//		} catch (OWLOntologyStorageException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.thalesgroup.CertificateWrapper#createCertificate(java.lang.String)
	 */
	@Override
	public DTWC createCertificate(String name, String path) {

		try {	       
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

			

			File f = new File(path);

			MyOntology = manager.loadOntologyFromOntologyDocument(f);

			MyFactory factory = new MyFactory(MyOntology);
			
			com.thalesgroup.dtwc.protege.DTWC dtwc_p = factory.createDTWC(name);
			
			dtwc = new DTWCImpl(dtwc_p, factory);
			
			return dtwc;
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.CertificateWrapper#loadCertificate(java.lang.String)
	 */
	@Override
	public DTWC loadCertificate(String name, String path) {
		try {	       
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

			File f = new File(path);

			MyOntology = manager.loadOntologyFromOntologyDocument(f);

			MyFactory factory = new MyFactory(MyOntology);

			 Collection<? extends com.thalesgroup.dtwc.protege.DTWC> col = factory.getAllDTWCInstances();
			 System.out.println("siez " + col.size());
			 com.thalesgroup.dtwc.protege.DTWC dtwc_p = null;
			for (Iterator iterator = col.iterator(); iterator.hasNext();) {
				dtwc_p = (com.thalesgroup.dtwc.protege.DTWC) iterator.next();
				break;
			}
			
//			com.thalesgroup.dtwc.protege.DTWC dtwc_p = factory.createDTWC(name);

			
			dtwc = new DTWCImpl(dtwc_p, factory);

			return dtwc;
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.CertificateWrapper#removeCertificate(java.lang.String)
	 */
	@Override
	public void removeCertificate(String name) {
		// TODO Auto-generated method stub

	}

	public void printCertificate(String path) throws IOException, OWLOntologyStorageException{
		
		TurtleOntologyFormat turtleFormat = new TurtleOntologyFormat();
		
		//Path testFile = Files.createTempFile("prov", ".ttl");
		Path testFile = Paths.get(URI.create(path));
		try (OutputStream outputStream = Files.newOutputStream(testFile)) {
			System.out.println("test1");
			System.out.println("MyOntology is null " + MyOntology);
			System.out.println("outputStream is null " + outputStream);
			MyOntology.getOWLOntologyManager().saveOntology(MyOntology, turtleFormat,	
			outputStream);
			System.out.println("test2");
			}
		System.out.println(testFile);
	}
	
	
	public void printXMLCertificate(String path) throws IOException, OWLOntologyStorageException{
		
		RDFXMLOntologyFormat xmlFormat = new RDFXMLOntologyFormat();
		
		//Path testFile = Files.createTempFile("prov", ".ttl");
		Path testFile = Paths.get(URI.create(path));
		try (OutputStream outputStream = Files.newOutputStream(testFile)) {
			System.out.println("test1");
			System.out.println("MyOntology is null " + MyOntology);
			System.out.println("outputStream is null " + outputStream);
			MyOntology.getOWLOntologyManager().saveOntology(MyOntology, xmlFormat,	
			outputStream);
			System.out.println("test2");
			}
		System.out.println(testFile);
	}	
	
}
