package com.thalesgroup.dtwc.protege;

import com.thalesgroup.dtwc.protege.impl.*;

import java.util.Collection;

import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: MyFactory<br>
 * @version generated on Wed Oct 08 11:02:03 CEST 2014 by t0013577
 */
public class MyFactory implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public MyFactory(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public MyFactory(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Asset
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Asset", Asset.class, DefaultAsset.class);
    }

    /**
     * Creates an instance of type Asset.  Modifies the underlying ontology.
     */
    public Asset createAsset(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_ASSET, DefaultAsset.class);
    }

    /**
     * Gets an instance of type Asset with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Asset getAsset(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_ASSET, DefaultAsset.class);
    }

    /**
     * Gets all instances of Asset from the ontology.
     */
    public Collection<? extends Asset> getAllAssetInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_ASSET, DefaultAsset.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Attribute
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Attribute", Attribute.class, DefaultAttribute.class);
    }

    /**
     * Creates an instance of type Attribute.  Modifies the underlying ontology.
     */
    public Attribute createAttribute(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_ATTRIBUTE, DefaultAttribute.class);
    }

    /**
     * Gets an instance of type Attribute with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Attribute getAttribute(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_ATTRIBUTE, DefaultAttribute.class);
    }

    /**
     * Gets all instances of Attribute from the ontology.
     */
    public Collection<? extends Attribute> getAllAttributeInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_ATTRIBUTE, DefaultAttribute.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Behaviour
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Behaviour", Behaviour.class, DefaultBehaviour.class);
    }

    /**
     * Creates an instance of type Behaviour.  Modifies the underlying ontology.
     */
    public Behaviour createBehaviour(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BEHAVIOUR, DefaultBehaviour.class);
    }

    /**
     * Gets an instance of type Behaviour with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Behaviour getBehaviour(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BEHAVIOUR, DefaultBehaviour.class);
    }

    /**
     * Gets all instances of Behaviour from the ontology.
     */
    public Collection<? extends Behaviour> getAllBehaviourInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BEHAVIOUR, DefaultBehaviour.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#CertifiedEvidence
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#CertifiedEvidence", CertifiedEvidence.class, DefaultCertifiedEvidence.class);
    }

    /**
     * Creates an instance of type CertifiedEvidence.  Modifies the underlying ontology.
     */
    public CertifiedEvidence createCertifiedEvidence(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CERTIFIEDEVIDENCE, DefaultCertifiedEvidence.class);
    }

    /**
     * Gets an instance of type CertifiedEvidence with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public CertifiedEvidence getCertifiedEvidence(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CERTIFIEDEVIDENCE, DefaultCertifiedEvidence.class);
    }

    /**
     * Gets all instances of CertifiedEvidence from the ontology.
     */
    public Collection<? extends CertifiedEvidence> getAllCertifiedEvidenceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CERTIFIEDEVIDENCE, DefaultCertifiedEvidence.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Component
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Component", Component.class, DefaultComponent.class);
    }

    /**
     * Creates an instance of type Component.  Modifies the underlying ontology.
     */
    public Component createComponent(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_COMPONENT, DefaultComponent.class);
    }

    /**
     * Gets an instance of type Component with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Component getComponent(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_COMPONENT, DefaultComponent.class);
    }

    /**
     * Gets all instances of Component from the ontology.
     */
    public Collection<? extends Component> getAllComponentInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_COMPONENT, DefaultComponent.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#ComponentModel
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#ComponentModel", ComponentModel.class, DefaultComponentModel.class);
    }

    /**
     * Creates an instance of type ComponentModel.  Modifies the underlying ontology.
     */
    public ComponentModel createComponentModel(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_COMPONENTMODEL, DefaultComponentModel.class);
    }

    /**
     * Gets an instance of type ComponentModel with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public ComponentModel getComponentModel(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_COMPONENTMODEL, DefaultComponentModel.class);
    }

    /**
     * Gets all instances of ComponentModel from the ontology.
     */
    public Collection<? extends ComponentModel> getAllComponentModelInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_COMPONENTMODEL, DefaultComponentModel.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Context
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Context", Context.class, DefaultContext.class);
    }

    /**
     * Creates an instance of type Context.  Modifies the underlying ontology.
     */
    public Context createContext(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONTEXT, DefaultContext.class);
    }

    /**
     * Gets an instance of type Context with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Context getContext(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONTEXT, DefaultContext.class);
    }

    /**
     * Gets all instances of Context from the ontology.
     */
    public Collection<? extends Context> getAllContextInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTEXT, DefaultContext.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Control
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Control", Control.class, DefaultControl.class);
    }

    /**
     * Creates an instance of type Control.  Modifies the underlying ontology.
     */
    public Control createControl(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CONTROL, DefaultControl.class);
    }

    /**
     * Gets an instance of type Control with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Control getControl(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CONTROL, DefaultControl.class);
    }

    /**
     * Gets all instances of Control from the ontology.
     */
    public Collection<? extends Control> getAllControlInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTROL, DefaultControl.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#DTWC
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#DTWC", DTWC.class, DefaultDTWC.class);
    }

    /**
     * Creates an instance of type DTWC.  Modifies the underlying ontology.
     */
    public DTWC createDTWC(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DTWC, DefaultDTWC.class);
    }

    /**
     * Gets an instance of type DTWC with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public DTWC getDTWC(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DTWC, DefaultDTWC.class);
    }

    /**
     * Gets all instances of DTWC from the ontology.
     */
    public Collection<? extends DTWC> getAllDTWCInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DTWC, DefaultDTWC.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Evidence
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Evidence", Evidence.class, DefaultEvidence.class);
    }

    /**
     * Creates an instance of type Evidence.  Modifies the underlying ontology.
     */
    public Evidence createEvidence(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_EVIDENCE, DefaultEvidence.class);
    }

    /**
     * Gets an instance of type Evidence with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Evidence getEvidence(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_EVIDENCE, DefaultEvidence.class);
    }

    /**
     * Gets all instances of Evidence from the ontology.
     */
    public Collection<? extends Evidence> getAllEvidenceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_EVIDENCE, DefaultEvidence.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Metric
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Metric", Metric.class, DefaultMetric.class);
    }

    /**
     * Creates an instance of type Metric.  Modifies the underlying ontology.
     */
    public Metric createMetric(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_METRIC, DefaultMetric.class);
    }

    /**
     * Gets an instance of type Metric with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Metric getMetric(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_METRIC, DefaultMetric.class);
    }

    /**
     * Gets all instances of Metric from the ontology.
     */
    public Collection<? extends Metric> getAllMetricInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_METRIC, DefaultMetric.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#MetricRuntimeCalculation
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#MetricRuntimeCalculation", MetricRuntimeCalculation.class, DefaultMetricRuntimeCalculation.class);
    }

    /**
     * Creates an instance of type MetricRuntimeCalculation.  Modifies the underlying ontology.
     */
    public MetricRuntimeCalculation createMetricRuntimeCalculation(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_METRICRUNTIMECALCULATION, DefaultMetricRuntimeCalculation.class);
    }

    /**
     * Gets an instance of type MetricRuntimeCalculation with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public MetricRuntimeCalculation getMetricRuntimeCalculation(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_METRICRUNTIMECALCULATION, DefaultMetricRuntimeCalculation.class);
    }

    /**
     * Gets all instances of MetricRuntimeCalculation from the ontology.
     */
    public Collection<? extends MetricRuntimeCalculation> getAllMetricRuntimeCalculationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_METRICRUNTIMECALCULATION, DefaultMetricRuntimeCalculation.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#RuntimeEvidence
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#RuntimeEvidence", RuntimeEvidence.class, DefaultRuntimeEvidence.class);
    }

    /**
     * Creates an instance of type RuntimeEvidence.  Modifies the underlying ontology.
     */
    public RuntimeEvidence createRuntimeEvidence(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RUNTIMEEVIDENCE, DefaultRuntimeEvidence.class);
    }

    /**
     * Gets an instance of type RuntimeEvidence with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public RuntimeEvidence getRuntimeEvidence(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RUNTIMEEVIDENCE, DefaultRuntimeEvidence.class);
    }

    /**
     * Gets all instances of RuntimeEvidence from the ontology.
     */
    public Collection<? extends RuntimeEvidence> getAllRuntimeEvidenceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RUNTIMEEVIDENCE, DefaultRuntimeEvidence.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Stakeholder
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Stakeholder", Stakeholder.class, DefaultStakeholder.class);
    }

    /**
     * Creates an instance of type Stakeholder.  Modifies the underlying ontology.
     */
    public Stakeholder createStakeholder(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_STAKEHOLDER, DefaultStakeholder.class);
    }

    /**
     * Gets an instance of type Stakeholder with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Stakeholder getStakeholder(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_STAKEHOLDER, DefaultStakeholder.class);
    }

    /**
     * Gets all instances of Stakeholder from the ontology.
     */
    public Collection<? extends Stakeholder> getAllStakeholderInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_STAKEHOLDER, DefaultStakeholder.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#SubComponent
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#SubComponent", SubComponent.class, DefaultSubComponent.class);
    }

    /**
     * Creates an instance of type SubComponent.  Modifies the underlying ontology.
     */
    public SubComponent createSubComponent(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SUBCOMPONENT, DefaultSubComponent.class);
    }

    /**
     * Gets an instance of type SubComponent with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public SubComponent getSubComponent(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SUBCOMPONENT, DefaultSubComponent.class);
    }

    /**
     * Gets all instances of SubComponent from the ontology.
     */
    public Collection<? extends SubComponent> getAllSubComponentInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SUBCOMPONENT, DefaultSubComponent.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#SystemDescription
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#SystemDescription", SystemDescription.class, DefaultSystemDescription.class);
    }

    /**
     * Creates an instance of type SystemDescription.  Modifies the underlying ontology.
     */
    public SystemDescription createSystemDescription(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SYSTEMDESCRIPTION, DefaultSystemDescription.class);
    }

    /**
     * Gets an instance of type SystemDescription with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public SystemDescription getSystemDescription(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SYSTEMDESCRIPTION, DefaultSystemDescription.class);
    }

    /**
     * Gets all instances of SystemDescription from the ontology.
     */
    public Collection<? extends SystemDescription> getAllSystemDescriptionInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SYSTEMDESCRIPTION, DefaultSystemDescription.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWAttribute
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWAttribute", TWAttribute.class, DefaultTWAttribute.class);
    }

    /**
     * Creates an instance of type TWAttribute.  Modifies the underlying ontology.
     */
    public TWAttribute createTWAttribute(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TWATTRIBUTE, DefaultTWAttribute.class);
    }

    /**
     * Gets an instance of type TWAttribute with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TWAttribute getTWAttribute(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TWATTRIBUTE, DefaultTWAttribute.class);
    }

    /**
     * Gets all instances of TWAttribute from the ontology.
     */
    public Collection<? extends TWAttribute> getAllTWAttributeInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TWATTRIBUTE, DefaultTWAttribute.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWProblemDefinition
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWProblemDefinition", TWProblemDefinition.class, DefaultTWProblemDefinition.class);
    }

    /**
     * Creates an instance of type TWProblemDefinition.  Modifies the underlying ontology.
     */
    public TWProblemDefinition createTWProblemDefinition(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TWPROBLEMDEFINITION, DefaultTWProblemDefinition.class);
    }

    /**
     * Gets an instance of type TWProblemDefinition with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TWProblemDefinition getTWProblemDefinition(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TWPROBLEMDEFINITION, DefaultTWProblemDefinition.class);
    }

    /**
     * Gets all instances of TWProblemDefinition from the ontology.
     */
    public Collection<? extends TWProblemDefinition> getAllTWProblemDefinitionInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TWPROBLEMDEFINITION, DefaultTWProblemDefinition.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWProperty
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWProperty", TWProperty.class, DefaultTWProperty.class);
    }

    /**
     * Creates an instance of type TWProperty.  Modifies the underlying ontology.
     */
    public TWProperty createTWProperty(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TWPROPERTY, DefaultTWProperty.class);
    }

    /**
     * Gets an instance of type TWProperty with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TWProperty getTWProperty(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TWPROPERTY, DefaultTWProperty.class);
    }

    /**
     * Gets all instances of TWProperty from the ontology.
     */
    public Collection<? extends TWProperty> getAllTWPropertyInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TWPROPERTY, DefaultTWProperty.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWPropertySpecification
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#TWPropertySpecification", TWPropertySpecification.class, DefaultTWPropertySpecification.class);
    }

    /**
     * Creates an instance of type TWPropertySpecification.  Modifies the underlying ontology.
     */
    public TWPropertySpecification createTWPropertySpecification(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_TWPROPERTYSPECIFICATION, DefaultTWPropertySpecification.class);
    }

    /**
     * Gets an instance of type TWPropertySpecification with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public TWPropertySpecification getTWPropertySpecification(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_TWPROPERTYSPECIFICATION, DefaultTWPropertySpecification.class);
    }

    /**
     * Gets all instances of TWPropertySpecification from the ontology.
     */
    public Collection<? extends TWPropertySpecification> getAllTWPropertySpecificationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_TWPROPERTYSPECIFICATION, DefaultTWPropertySpecification.class);
    }


    /* ***************************************************
     * Class http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Threat
     */

    {
        javaMapping.add("http://www.optet.eu/ns/DigitalTrustworthinessCertificate#Threat", Threat.class, DefaultThreat.class);
    }

    /**
     * Creates an instance of type Threat.  Modifies the underlying ontology.
     */
    public Threat createThreat(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_THREAT, DefaultThreat.class);
    }

    /**
     * Gets an instance of type Threat with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Threat getThreat(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_THREAT, DefaultThreat.class);
    }

    /**
     * Gets all instances of Threat from the ontology.
     */
    public Collection<? extends Threat> getAllThreatInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_THREAT, DefaultThreat.class);
    }


    /* ***************************************************
     * Class http://xmlns.com/foaf/0.1/Person
     */

    {
        javaMapping.add("http://xmlns.com/foaf/0.1/Person", Person.class, DefaultPerson.class);
    }

    /**
     * Creates an instance of type Person.  Modifies the underlying ontology.
     */
    public Person createPerson(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }

    /**
     * Gets an instance of type Person with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Person getPerson(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }

    /**
     * Gets all instances of Person from the ontology.
     */
    public Collection<? extends Person> getAllPersonInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }


}
