package mc.ontology;

import java.io.InputStream;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class OntologyReader {

	private Model model;
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public OntologyReader() {
		// create an empty model
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);

		InputStream in = FileManager.get().open(Constants.ontologyFileName);
		if (in == null) {
			throw new IllegalArgumentException("File: " + Constants.ontologyFileName
					+ " not found");
		}

		model.read(in, null);
		
	}
}
