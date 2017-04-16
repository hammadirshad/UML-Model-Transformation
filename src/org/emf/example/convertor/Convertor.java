package org.emf.example.convertor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.emf.example.model.ModelLoader;

public class Convertor {
	/**
	 * file extension of ecore file.
	 */
	protected static final String UML_FILE_EXTENSION = "uml";
	protected static final String ECORE_FILE_EXTENSION = "ecore";
	protected static final String GENMODEL_FILE_EXTENSION = "genmodel";

	/**
	 * Constructor of this class.
	 */
	private ModelLoader umlModel = null;

	public Convertor() {
		umlModel = new ModelLoader();
	}

	/**
	 * initiate the option of the ecore creation.
	 *
	 * @return map of option.
	 */

	public void umlToEcore(File model) throws IOException, Exception {
		Package _package = umlModel.loadModel(model);
		umlToEcore(_package);
	}

	/**
	 * initiate the option of the genmodel creation.
	 *
	 * @return map of option.
	 */




	public void umlToGenmodel(File model) throws IOException, Exception {
		Package _package = umlModel.loadModel(model);
		umlToGenmodel(_package);
	}



	/**
	 * initiate the option of the genmodel creation.
	 *
	 * @return map of option.
	 */




	public void ecoreToUML(File model) throws IOException, Exception {
		EPackage ePackage = umlModel.loadEcoreModel(model);
		ecoreToUML(ePackage);
	}

	/**
	 * Create an ecore model from an uml model.
	 *
	 * @param ePackage
	 *            (profile/class) the uml file
	 * @return an ecore model
	 */
	public Resource ecoreToUML(final EPackage ePackage) {

		final Map<String, String> options = ConverterProperties.initAllOptionsToProcess();

		final Collection<Package> umlPackages = UMLUtil.convertFromEcore(ePackage, options);

		final URI uri = ModelLoader.getResourceSet().getURIConverter().normalize(ePackage.eResource().getURI())
				.trimFileExtension().trimSegments(1);

		final List<Resource> resources = new ArrayList<Resource>();
		Resource resource = null;
		for (final Package _package : umlPackages) {
			if (_package != null) {
				URI uml = uri.appendSegment(ePackage.getName()).appendFileExtension(UML_FILE_EXTENSION);
				System.out.println(uml);
				resource = ModelLoader.getResourceSet().createResource(uml);
				resources.add(resource);
				resource.getContents().add(_package);
			}
			break;
		}

		for (final Resource r : resources) {

			try {
				r.save(null);
			} catch (final Exception e) {
				System.err.println("umlToEcore(" + ePackage.getClass() + ") not handled");
				e.printStackTrace();
			}
		}

		return resources.get(0);
	}

	/**
	 * Create an ecore model from an uml model.
	 *
	 * @param _package
	 *            (profile/class) the uml file
	 * @return an ecore model
	 */
	public Resource umlToEcore(final org.eclipse.uml2.uml.Package _package) {

		final Map<String, String> options = ConverterProperties.initAllOptionsToProcess();

		final Collection<EPackage> ecorePackages = UMLUtil.convertToEcore(_package, options, null, null);

		final URI uri = ModelLoader.getResourceSet().getURIConverter().normalize(_package.eResource().getURI())
				.trimFileExtension().trimSegments(1);

		final List<Resource> resources = new ArrayList<Resource>();
		Resource resource = null;
		for (final EPackage ePackage : ecorePackages) {

			if (ePackage != null) {

				URI ecore = uri.appendSegment(ePackage.getName()).appendFileExtension(ECORE_FILE_EXTENSION);
				System.out.println(ecore);
				resource = ModelLoader.getResourceSet().createResource(ecore);
				resources.add(resource);
				resource.getContents().add(ePackage);

			}

		}

		for (final Resource r : resources) {

			try {
				r.save(null);
			} catch (final Exception e) {

				System.err.println("umlToEcore(" + _package.getClass() + ") not handled");
				e.printStackTrace();
			}
		}

		return resources.get(0);
	}

	/**
	 * Create an genmode model from an uml model.
	 *
	 * @param _package
	 *            (profile/class) the uml file
	 * @return
	 */
	public Resource umlToGenmodel(final org.eclipse.uml2.uml.Package _package) {

		final Map<String, String> options = ConverterProperties.initAllOptionsToProcess();

		final Collection<EPackage> ecorePackages = UMLUtil.convertToEcore(_package, options, null, null);

		final URI uri = ModelLoader.getResourceSet().getURIConverter().normalize(_package.eResource().getURI())
				.trimFileExtension().trimSegments(1);

		final List<Resource> resources = new ArrayList<Resource>();
		Resource resource = null;
		for (final EPackage ePackage : ecorePackages) {

			if (ePackage != null) {

				URI ecore = uri.appendSegment(ePackage.getName()).appendFileExtension(ECORE_FILE_EXTENSION);
				System.out.println(ecore);
				resource = ModelLoader.getResourceSet().createResource(ecore);
				resources.add(resource);
				resource.getContents().add(ePackage);

				URI genmodel = uri.appendSegment(ePackage.getName()).appendFileExtension(GENMODEL_FILE_EXTENSION);
				System.out.println(genmodel);

				GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
				genModel.setComplianceLevel(GenJDKLevel.JDK70_LITERAL);
				genModel.setModelDirectory("code");
				genModel.getForeignModel().add(ecore.lastSegment());
				genModel.setModelName("modelTest");
				genModel.setRootExtendsInterface("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
				genModel.initialize(Collections.singleton(ePackage));
				GenPackage genPackage = (GenPackage) genModel.getGenPackages().get(0);
				genPackage.setPrefix("ModelTest");

				resource = ModelLoader.getResourceSet().createResource(genmodel);
				resources.add(resource);
			//	generate(genModel);
				if (resource.getContents() != null)
					resource.getContents().add(genModel);

			}
		}

		for (final Resource r : resources) {

			try {
				r.save(null);
			} catch (final Exception e) {

				System.err.println("umlToEcore(" + _package.getClass() + ") not handled");
				e.printStackTrace();
			}
		}
		return resources.get(0);
	}

	public void generate(GenModel genModel) {
		// Generate Code
		
		genModel.setCanGenerate(true);
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI,
				GenModelGeneratorAdapterFactory.DESCRIPTOR);

		// Create the generator and set the model-level input object.
		Generator generator = new Generator();
		generator.setInput(genModel);
		genModel.setFacadeHelperClass(getClass().getName());
		
		// Generator model code.
		Diagnostic d = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.Printing(System.out));

		System.out.println("Message: "+d.getMessage());
		System.out.println("Source: "+d.getSource());
	}
}