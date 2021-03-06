package com.thalesgroup.dtwc.protege;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Metric <br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */

public interface Metric extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasMetricCalculationMethod
     */
     
    /**
     * Gets all property values for the hasMetricCalculationMethod property.<p>
     * 
     * @returns a collection of values for the hasMetricCalculationMethod property.
     */
    Collection<? extends WrappedIndividual> getHasMetricCalculationMethod();

    /**
     * Checks if the class has a hasMetricCalculationMethod property value.<p>
     * 
     * @return true if there is a hasMetricCalculationMethod property value.
     */
    boolean hasHasMetricCalculationMethod();

    /**
     * Adds a hasMetricCalculationMethod property value.<p>
     * 
     * @param newHasMetricCalculationMethod the hasMetricCalculationMethod property value to be added
     */
    void addHasMetricCalculationMethod(WrappedIndividual newHasMetricCalculationMethod);

    /**
     * Removes a hasMetricCalculationMethod property value.<p>
     * 
     * @param oldHasMetricCalculationMethod the hasMetricCalculationMethod property value to be removed.
     */
    void removeHasMetricCalculationMethod(WrappedIndividual oldHasMetricCalculationMethod);


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
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasUnit
     */
     
    /**
     * Gets all property values for the hasUnit property.<p>
     * 
     * @returns a collection of values for the hasUnit property.
     */
    Collection<? extends Object> getHasUnit();

    /**
     * Checks if the class has a hasUnit property value.<p>
     * 
     * @return true if there is a hasUnit property value.
     */
    boolean hasHasUnit();

    /**
     * Adds a hasUnit property value.<p>
     * 
     * @param newHasUnit the hasUnit property value to be added
     */
    void addHasUnit(Object newHasUnit);

    /**
     * Removes a hasUnit property value.<p>
     * 
     * @param oldHasUnit the hasUnit property value to be removed.
     */
    void removeHasUnit(Object oldHasUnit);



    /* ***************************************************
     * Property http://www.optet.eu/ns/DigitalTrustworthinessCertificate#hasValue
     */
     
    /**
     * Gets all property values for the hasValue property.<p>
     * 
     * @returns a collection of values for the hasValue property.
     */
    Collection<? extends Object> getHasValue();

    /**
     * Checks if the class has a hasValue property value.<p>
     * 
     * @return true if there is a hasValue property value.
     */
    boolean hasHasValue();

    /**
     * Adds a hasValue property value.<p>
     * 
     * @param newHasValue the hasValue property value to be added
     */
    void addHasValue(Object newHasValue);

    /**
     * Removes a hasValue property value.<p>
     * 
     * @param oldHasValue the hasValue property value to be removed.
     */
    void removeHasValue(Object oldHasValue);



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
