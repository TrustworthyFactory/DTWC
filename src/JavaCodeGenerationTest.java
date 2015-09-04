import java.io.File;

import org.protege.owl.codegeneration.CodeGenerationOptions;
import org.protege.owl.codegeneration.DefaultWorker;
import org.protege.owl.codegeneration.JavaCodeGenerator;
import org.protege.owl.codegeneration.Worker;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.ReasonerBasedInference;
import org.protege.owl.codegeneration.inference.SimpleInference;
import org.protege.owl.codegeneration.names.CodeGenerationNames;
import org.protege.owl.codegeneration.names.IriNames;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;




public class JavaCodeGenerationTest {

	public static void main(String[] args) {
		try {
			//create OWL Model
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			File f = new File("D:/temp/protege/dtwc.ttl");
			OWLOntology MyOntology = manager.loadOntologyFromOntologyDocument(f);
			//create and set options for the Java Code Generator 
			CodeGenerationOptions options = new CodeGenerationOptions();

			options.setOutputFolder(new File("C:\\test"));
			options.setPackage("protege.codegenerator.test");

			//the following 2 lines have no effect because the specified 
			//values are the default values for those properties
			options.setFactoryClassName("MyFactory");


			//for the options not specified (e.g. setSetMode(boolean value)) the default value will be used 









			long startTime = System.currentTimeMillis();
//			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//			addIRIMappers(manager);
//			OWLOntology owlOntology = manager.loadOntologyFromOntologyDocument(new File(GenerateTestCode.ONTOLOGY_ROOT, ontologyLocation));
//			CodeGenerationOptions options = new CodeGenerationOptions();
			options.setOutputFolder(new File("C:\\test"));
			options.setPackage("protege.codegenerator.test");

			//the following 2 lines have no effect because the specified 
			//values are the default values for those properties
			options.setFactoryClassName("MyFactory");
			CodeGenerationInference inference;
//			if (useInference) {
//				// OWLReasonerFactory rFactory = (OWLReasonerFactory) Class.forName("uk.ac.manchester.cs.jfact.JFactFactory").newInstance();
//				OWLReasonerFactory rFactory = (OWLReasonerFactory) Class.forName("org.semanticweb.HermiT.Reasoner$ReasonerFactory").newInstance();
//				// OWLReasonerFactory rFactory = (OWLReasonerFactory) Class.forName("com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory").newInstance();
//				OWLReasoner reasoner = rFactory.createNonBufferingReasoner(owlOntology);
//				inference = new ReasonerBasedInference(owlOntology, reasoner);
//			}
//			else {
				inference = new SimpleInference(MyOntology);
//			}
			// inference.preCompute();
			DefaultWorker.generateCode(MyOntology, options, new IriNames(MyOntology, options), inference);




	} catch (Exception e) {
		e.printStackTrace();
	}
}
}