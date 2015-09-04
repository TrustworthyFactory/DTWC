package com.thalesgroup.dtwc.protege;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: DTWC <br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */

public interface DTWC extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasEvidence
     */
     
    /**
     * Gets all property values for the hasEvidence property.<p>
     * 
     * @returns a collection of values for the hasEvidence property.
     */
    Collection<? extends WrappedIndividual> getHasEvidence();

    /**
     * Checks if the class has a hasEvidence property value.<p>
     * 
     * @return true if there is a hasEvidence property value.
     */
    boolean hasHasEvidence();

    /**
     * Adds a hasEvidence property value.<p>
     * 
     * @param newHasEvidence the hasEvidence property value to be added
     */
    void addHasEvidence(WrappedIndividual newHasEvidence);

    /**
     * Removes a hasEvidence property value.<p>
     * 
     * @param oldHasEvidence the hasEvidence property value to be removed.
     */
    void removeHasEvidence(WrappedIndividual oldHasEvidence);


    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasPart
     */
     
    /**
     * Gets all property values for the hasPart property.<p>
     * 
     * @returns a collection of values for the hasPart property.
     */
    Collection<? extends WrappedIndividual> getHasPart();

    /**
     * Checks if the class has a hasPart property value.<p>
     * 
     * @return true if there is a hasPart property value.
     */
    boolean hasHasPart();

    /**
     * Adds a hasPart property value.<p>
     * 
     * @param newHasPart the hasPart property value to be added
     */
    void addHasPart(WrappedIndividual newHasPart);

    /**
     * Removes a hasPart property value.<p>
     * 
     * @param oldHasPart the hasPart property value to be removed.
     */
    void removeHasPart(WrappedIndividual oldHasPart);


    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasTWProblemDefinition
     */
     
    /**
     * Gets all property values for the hasTWProblemDefinition property.<p>
     * 
     * @returns a collection of values for the hasTWProblemDefinition property.
     */
    Collection<? extends WrappedIndividual> getHasTWProblemDefinition();

    /**
     * Checks if the class has a hasTWProblemDefinition property value.<p>
     * 
     * @return true if there is a hasTWProblemDefinition property value.
     */
    boolean hasHasTWProblemDefinition();

    /**
     * Adds a hasTWProblemDefinition property value.<p>
     * 
     * @param newHasTWProblemDefinition the hasTWProblemDefinition property value to be added
     */
    void addHasTWProblemDefinition(WrappedIndividual newHasTWProblemDefinition);

    /**
     * Removes a hasTWProblemDefinition property value.<p>
     * 
     * @param oldHasTWProblemDefinition the hasTWProblemDefinition property value to be removed.
     */
    void removeHasTWProblemDefinition(WrappedIndividual oldHasTWProblemDefinition);


    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasTWPropertySpecification
     */
     
    /**
     * Gets all property values for the hasTWPropertySpecification property.<p>
     * 
     * @returns a collection of values for the hasTWPropertySpecification property.
     */
    Collection<? extends WrappedIndividual> getHasTWPropertySpecification();

    /**
     * Checks if the class has a hasTWPropertySpecification property value.<p>
     * 
     * @return true if there is a hasTWPropertySpecification property value.
     */
    boolean hasHasTWPropertySpecification();

    /**
     * Adds a hasTWPropertySpecification property value.<p>
     * 
     * @param newHasTWPropertySpecification the hasTWPropertySpecification property value to be added
     */
    void addHasTWPropertySpecification(WrappedIndividual newHasTWPropertySpecification);

    /**
     * Removes a hasTWPropertySpecification property value.<p>
     * 
     * @param oldHasTWPropertySpecification the hasTWPropertySpecification property value to be removed.
     */
    void removeHasTWPropertySpecification(WrappedIndividual oldHasTWPropertySpecification);


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
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasHash
     */
     
    /**
     * Gets all property values for the hasHash property.<p>
     * 
     * @returns a collection of values for the hasHash property.
     */
    Collection<? extends Object> getHasHash();

    /**
     * Checks if the class has a hasHash property value.<p>
     * 
     * @return true if there is a hasHash property value.
     */
    boolean hasHasHash();

    /**
     * Adds a hasHash property value.<p>
     * 
     * @param newHasHash the hasHash property value to be added
     */
    void addHasHash(Object newHasHash);

    /**
     * Removes a hasHash property value.<p>
     * 
     * @param oldHasHash the hasHash property value to be removed.
     */
    void removeHasHash(Object oldHasHash);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}