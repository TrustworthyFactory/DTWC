package com.thalesgroup.dtwc.protege.impl;

import com.thalesgroup.dtwc.protege.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultTWPropertySpecification <br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */
public class DefaultTWPropertySpecification extends WrappedIndividualImpl implements TWPropertySpecification {

    public DefaultTWPropertySpecification(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasControl
     */
     
    public Collection<? extends WrappedIndividual> getHasControl() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASCONTROL,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasControl() {
	   return !getHasControl().isEmpty();
    }

    public void addHasControl(WrappedIndividual newHasControl) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASCONTROL,
                                       newHasControl);
    }

    public void removeHasControl(WrappedIndividual oldHasControl) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASCONTROL,
                                          oldHasControl);
    }


    /* ***************************************************
     * Object Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasTWProperty
     */
     
    public Collection<? extends WrappedIndividual> getHasTWProperty() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASTWPROPERTY,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasTWProperty() {
	   return !getHasTWProperty().isEmpty();
    }

    public void addHasTWProperty(WrappedIndividual newHasTWProperty) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASTWPROPERTY,
                                       newHasTWProperty);
    }

    public void removeHasTWProperty(WrappedIndividual oldHasTWProperty) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASTWPROPERTY,
                                          oldHasTWProperty);
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


}