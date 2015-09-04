package com.thalesgroup.dtwc.protege.impl;

import com.thalesgroup.dtwc.protege.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultMetricRuntimeCalculation <br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */
public class DefaultMetricRuntimeCalculation extends WrappedIndividualImpl implements MetricRuntimeCalculation {

    public DefaultMetricRuntimeCalculation(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Data Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#ID
     */
     
    public Collection<? extends String> getID() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, String.class);
    }

    public boolean hasID() {
		return !getID().isEmpty();
    }

    public void addID(String newID) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, newID);
    }

    public void removeID(String oldID) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, oldID);
    }


    /* ***************************************************
     * Data Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasValue
     */
     
    public Collection<? extends Object> getHasValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, Object.class);
    }

    public boolean hasHasValue() {
		return !getHasValue().isEmpty();
    }

    public void addHasValue(Object newHasValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, newHasValue);
    }

    public void removeHasValue(Object oldHasValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASVALUE, oldHasValue);
    }


}
