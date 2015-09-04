package com.thalesgroup.dtwc.protege;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Threat <br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */

public interface Threat extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasControl
     */
     
    /**
     * Gets all property values for the hasControl property.<p>
     * 
     * @returns a collection of values for the hasControl property.
     */
    Collection<? extends WrappedIndividual> getHasControl();

    /**
     * Checks if the class has a hasControl property value.<p>
     * 
     * @return true if there is a hasControl property value.
     */
    boolean hasHasControl();

    /**
     * Adds a hasControl property value.<p>
     * 
     * @param newHasControl the hasControl property value to be added
     */
    void addHasControl(WrappedIndividual newHasControl);

    /**
     * Removes a hasControl property value.<p>
     * 
     * @param oldHasControl the hasControl property value to be removed.
     */
    void removeHasControl(WrappedIndividual oldHasControl);


    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#ID
     */
     
    /**
     * Gets all property values for the ID property.<p>
     * 
     * @returns a collection of values for the ID property.
     */
    Collection<? extends String> getID();

    /**
     * Checks if the class has a ID property value.<p>
     * 
     * @return true if there is a ID property value.
     */
    boolean hasID();

    /**
     * Adds a ID property value.<p>
     * 
     * @param newID the ID property value to be added
     */
    void addID(String newID);

    /**
     * Removes a ID property value.<p>
     * 
     * @param oldID the ID property value to be removed.
     */
    void removeID(String oldID);



    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#type
     */
     
    /**
     * Gets all property values for the type property.<p>
     * 
     * @returns a collection of values for the type property.
     */
    Collection<? extends String> getType();

    /**
     * Checks if the class has a type property value.<p>
     * 
     * @return true if there is a type property value.
     */
    boolean hasType();

    /**
     * Adds a type property value.<p>
     * 
     * @param newType the type property value to be added
     */
    void addType(String newType);

    /**
     * Removes a type property value.<p>
     * 
     * @param oldType the type property value to be removed.
     */
    void removeType(String oldType);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
