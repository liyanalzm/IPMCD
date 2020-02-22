package mc.processor;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mc.ontology.OntologyReader;
import mc.vo.Food;
import mc.vo.Phytochemical;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;

public class DataRetriever {

	private Model model;	// store ontology model
	
	// default constructor. When executed, read ontology model 1st
	public DataRetriever() {
		
		OntologyReader or = new OntologyReader();
		model = or.getModel();
	}
	
	/**
	 * get all NOT allowed vegetables
	 * @return
	 */
	public ArrayList<String> getAllNotAllowedVegetables() {
		ArrayList<String> allVeggies = getAllVegetables();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> notAllowedVeggies = new ArrayList<String>();
		
		for (String veggy : allVeggies) {
			if (((String)allRestrictions.get(veggy)).equals("NotAllowed")) {
				notAllowedVeggies.add(veggy);
			}
		}
		
		return notAllowedVeggies;
	}
	
	/**
	 * get all allowed vegetables
	 * @return
	 */
	public ArrayList<String> getAllAllowedVegetables() {
		ArrayList<String> allVeggies = getAllVegetables();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> allowedVeggies = new ArrayList<String>();
		
		for (String veggy : allVeggies) {
			if (((String)allRestrictions.get(veggy)).equals("Allowed")) {
				allowedVeggies.add(veggy);
			}
		}
		
		return allowedVeggies;
	}
	
	/**
	 * get all vegetables
	 * @return
	 */
	public ArrayList<String> getAllVegetables() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allVeggies = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Vegetable "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Veggies, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allVeggies.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allVeggies;
	}
	
	/**
	 * get all NOT allowed meats
	 * @return
	 */
	public ArrayList<String> getAllNotAllowedMeats() {
		ArrayList<String> allMeats = getAllMeats();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> notAllowedMeats = new ArrayList<String>();
		
		for (String meats : allMeats) {
			if (((String)allRestrictions.get(meats)).equals("NotAllowed")) {
				notAllowedMeats.add(meats);
			}
		}
		
		return notAllowedMeats;
	}
	
	/**
	 * get all allowed meats
	 * @return
	 */
	public ArrayList<String> getAllAllowedMeats() {
		ArrayList<String> allMeats = getAllMeats();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> allowedMeats = new ArrayList<String>();
		
		for (String meats : allMeats) {
			if (((String)allRestrictions.get(meats)).equals("Allowed")) {
				allowedMeats.add(meats);
			}
		}
		
		return allowedMeats;
	}
	
	/**
	 * get all meats
	 * @return
	 */
	public ArrayList<String> getAllMeats() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allMeats = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Meat "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Meats, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allMeats.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allMeats;
	}
	
	/**
	 * get all NOT allowed fruits
	 * @return
	 */
	public ArrayList<String> getAllNotAllowedFruits() {
		ArrayList<String> allFruits = getAllFruits();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> notAllowedFruits = new ArrayList<String>();
		
		for (String fruits : allFruits) {
			if (((String)allRestrictions.get(fruits)).equals("NotAllowed")) {
				notAllowedFruits.add(fruits);
			}
		}
		
		return notAllowedFruits;
	}
	
	/**
	 * get all allowed fruits
	 * @return
	 */
	public ArrayList<String> getAllAllowedFruits() {
		ArrayList<String> allFruits = getAllFruits();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> allowedFruits = new ArrayList<String>();
		
		for (String fruits : allFruits) {
			if (((String)allRestrictions.get(fruits)).equals("Allowed")) {
				allowedFruits.add(fruits);
			}
		}
		
		return allowedFruits;
	}
	
	/**
	 * get all fruits
	 * @return
	 */
	public ArrayList<String> getAllFruits() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allFruits = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Fruit "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Fruits, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allFruits.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allFruits;
	}
	
	/**
	 * get all NOT allowed others
	 * @return
	 */
	public ArrayList<String> getAllNotAllowedOthers() {
		ArrayList<String> allOthers = getAllOthers();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> notAllowedOthers = new ArrayList<String>();
		
		for (String others : allOthers) {
			if (((String)allRestrictions.get(others)).equals("NotAllowed")) {
				notAllowedOthers.add(others);
			}
		}
		
		return notAllowedOthers;
	}
	
	/**
	 * get all allowed others
	 * @return
	 */
	public ArrayList<String> getAllAllowedOthers() {
		ArrayList<String> allOthers = getAllOthers();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> allowedOthers = new ArrayList<String>();
		for (String others : allOthers) {
			if (((String)allRestrictions.get(others)).equals("Allowed")) {
				allowedOthers.add(others);
			}
		}
		
		return allowedOthers;
	}
	
	/**
	 * get all others
	 * @return
	 */
	public ArrayList<String> getAllOthers() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allOthers = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Others "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Others, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allOthers.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allOthers;
	}
	
	/**
	 * get all NOT allowed herbs
	 * @return
	 */
	public ArrayList<String> getAllNotAllowedHerbs() {
		ArrayList<String> allHerbs = getAllHerbs();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> notAllowedHerbs = new ArrayList<String>();
		
		System.out.println(allRestrictions);
		
		for (String herbs : allHerbs) {
			
			try{
				if (((String)allRestrictions.get(herbs)).equals("NotAllowed")) {
					System.out.println("Hello");
					notAllowedHerbs.add(herbs);
			}
				else{
					System.out.println("ada je");
				}
			
			}
			catch (Exception e ){
				System.out.println("Failed to get Data");
			}
		}
		System.out.println(notAllowedHerbs);
		return notAllowedHerbs;
	}
	
	
	/**
	 * get all allowed herbs
	 * @return
	 */
	public ArrayList<String> getAllAllowedHerbs() {
		ArrayList<String> allHerbs = getAllHerbs();
		HashMap<String, String> allRestrictions = getAllRestrictions();
		ArrayList<String> allowedHerbs = new ArrayList<String>();
				
		for (String herbs : allHerbs) {
		
			try{
			if (((String)allRestrictions.get(herbs)).equals("Allowed")) {
				allowedHerbs.add(herbs);
			}
			
			}
			catch (Exception e ){
				System.out.println(herbs);
			}
		}
		
		return allowedHerbs;
	}
	
	/**
	 * get all herbs
	 * @return
	 */
	public ArrayList<String> getAllHerbs() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allHerbs = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Herbs "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Herbs, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allHerbs.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allHerbs;
	}
	
	/**
	 * get all food restrictions
	 * @return
	 */
	public HashMap<String, String> getAllRestrictions() {
		HashMap<String, String> restrictions = new HashMap<String, String>();
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass ?dataRange "
				+ " WHERE { "
				+ " ?subClass ?predicate ?object. "
				+ " ?object owl:onProperty mo:hasRestriction; "
				+ " owl:allValuesFrom ?dataRange. "
				+ "}";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			String result = qs.get(vars.get(0)).toString();
			String food = result.substring(result.indexOf('#')+1).trim();
			result = qs.get(vars.get(1)).toString();
			String res = result.substring(result.indexOf('#')+1).trim();
			restrictions.put(food, res);
		}
		// Important - free up resources used running the query
		qe.close();
		
		return restrictions;
	}
	

	//starts universal queries
	/**
	 * get all subclasses of a class
	 * @param className
	 * @return
	 */
	public ArrayList<String> getAllSubclasses(String className) {
		ArrayList<String> subClasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:" + className + " "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				subClasses.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return subClasses;
	}
	
	/**
	 * get food information from ontology model
	 * @param foodName
	 * @return
	 */
	public Food getFoodInfo(String foodName) {
		Food foodInfo = new Food();
		
		foodInfo.setFoodName(foodName);
		foodInfo.setReasons(getReasons(foodName));
		foodInfo.setEnhance(getEnhance(foodName));
		foodInfo.setPhytochemical(getPhytochemical(foodName));
		foodInfo.setPyramidLevel(getLevel(foodName));
		foodInfo.setRestriction(getRestriction(foodName));
		foodInfo.setColour(getColour(foodName));
		return foodInfo;
	}
	
	
	/**
	 * get phytochemical information from ontology model
	 * @param phytoName
	 * @return
	 */
	public Phytochemical getPhytochemicalsInfo(String phytoName) {
		Phytochemical phytoInfo = new Phytochemical();
		phytoInfo.setPhytochemical(getPhytochemical(phytoName));
		phytoInfo.setBenefit(getBenefit(phytoName));
		phytoInfo.setProperty(getProperty(phytoName));
		phytoInfo.setColour(getColour(phytoName));
		return phytoInfo;
	}
	
	/**
	 * get food information for not allowed class from ontology model
	 * @param foodName
	 * @return
	 */
	public Food getFoodInfo2(String foodName) {
		Food foodInfo = new Food();
		
		foodInfo.setFoodName(foodName);
		foodInfo.setReasons(getReasons(foodName));
		foodInfo.setPyramidLevel(getLevel(foodName));
		foodInfo.setColour(getColour(foodName));
		return foodInfo;
	}
	
	public ArrayList<String> getReasons(String foodName) {
		ArrayList<String> reasons = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasReason; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				reasons.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return reasons;
	}
	
	public ArrayList<String> getEnhance(String foodName) {
		ArrayList<String> enhance = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:isEnhance; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				enhance.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return enhance;
	}

	public ArrayList<String> getPhytochemical(String foodName) {
		ArrayList<String> phytochemical = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasPhytochemical; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				phytochemical.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return phytochemical;
	}

	public ArrayList<String> getBenefit(String phytoName) {
		ArrayList<String> benefit = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasBenefit; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+phytoName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				benefit.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return benefit;
	}

	public ArrayList<String> getProperty(String phytoName) {
		ArrayList<String> property = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasProperty; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+phytoName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				property.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return property;
	}

	public String getLevel(String foodName) {
		String level = null;
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasLevel; "
				+ " owl:allValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				level = result.substring(result.indexOf('#')+1).trim();
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return level;
	}
	
	public String getRestriction(String foodName) {
		String level = null;
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasRestriction; "
				+ " owl:allValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				level = result.substring(result.indexOf('#')+1).trim();
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return level;
	}
	
	public ArrayList<String> getFoodHierarchy(String foodName) {
		ArrayList<String> hierarchy = new ArrayList<String>();
		hierarchy.add(foodName);
		String parent = getParentClass(foodName);
		
		if((parent.equals("Shrubs")) || (parent.equals("Trees")) || (parent.equals("Climbers")) || (parent.equals("Other_Herbs")) ) {
			while (!parent.equals("Herbs") ) {
				hierarchy.add(parent);
				parent = getParentClass(parent);
			}
			hierarchy.add("Herbs");
		}else {
			while (!parent.equals("Food") ) {
				hierarchy.add(parent);
				parent = getParentClass(parent);
			}
			hierarchy.add("Food");
		}
		return hierarchy;
	}
	

	public ArrayList<String> getPhytochemicalsHierarchy(String phytoName) {
		ArrayList<String> hierarchy = new ArrayList<String>();
		hierarchy.add(phytoName);
		String parent = getParentClass(phytoName);
		while (!parent.equals("Phytochemical")) {
			hierarchy.add(parent);
			parent = getParentClass(parent);
		}
		hierarchy.add("Phytochemical");
		
		return hierarchy;
	}
	
	public String getParentClass(String subClass) {
		String parentClass = null;
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?parent "
				+ " WHERE { "
				+ " mo:" + subClass + " rdfs:subClassOf ?parent . "
				+ " ?parent rdf:type owl:Class "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				parentClass = result.substring(result.indexOf('#')+1).trim();
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return parentClass;
	}
	
	public ArrayList<String> getAllFoods() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allFoods = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Food "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Food, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allFoods.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allFoods;
	}
	
	public ArrayList<String> getAllPhytochemicals() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allPhytochemicals = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Phytochemical "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Phytochemicals, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Phytochemical objects
				allPhytochemicals.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allPhytochemicals;
	}
	
	public ArrayList<String> getVegetables() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Vegetable "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getFruits() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Fruit "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}

	public ArrayList<String> getPhytochemicals() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Phytochemical "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	public String getColour(String foodName) {
		String colour = null;
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasColor; "
				+ " owl:allValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				colour = result.substring(result.indexOf('#')+1).trim();
				
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return colour;
	}
	
	public ArrayList<String> getMeat() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Meat "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getOthers() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Others "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getHerbs() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Herbs "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getFoodTaxonomy(String foodName) {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:"+foodName+" "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getPhytochemicalsTaxonomy(String phytoName) {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:"+phytoName+" "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getAllTax(String foodName) {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allFoods = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:"+foodName+" "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Foods, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allFoods.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allFoods;
	}
	
	public ArrayList<String> getIntakes() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Intake "
				+ " } ";
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getPreparationMethods() {
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " {?subClass rdfs:subClassOf mo:Preparation}"
				+ " UNION {  ?subClass rdfs:subClassOf mo:Cook  } "
				+ " } ";
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				if(!(result.substring(result.indexOf('#')+1).trim().equalsIgnoreCase("Cook"))) {
					classes.add(result.substring(result.indexOf('#')+1).trim());
				}
				
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getPreparationMethod(String foodName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasPreparationMethod; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getDishForSpecificFood(String methodName, String foodName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasPurpose; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+methodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		ArrayList<String> dish = new ArrayList<String>();
		for(int i=0; i< classes.size();i++) {
			ArrayList<String> ingredients = new ArrayList<String>();
			String ingredientString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
					+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
					+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
					+ " SELECT  ?dataRange "
					+ " WHERE { "
					+ " ?subClass rdfs:subClassOf ?restriction . "
					+ " ?restriction owl:onProperty mo:hasIngredients; "
					+ " owl:someValuesFrom ?dataRange. "
					+ " FILTER(?subClass = mo:"+classes.get(i)+") "
					+ " }";
			
			Query ingQuery = QueryFactory.create(ingredientString, Syntax.syntaxARQ);
			
			// Execute the query and obtain results
			QueryExecution ingQe = QueryExecutionFactory.create(ingQuery, model);
			
			ResultSet ingResults = ingQe.execSelect();
			List<String> ingVars = ingResults.getResultVars();
			while (ingResults.hasNext()) {
				QuerySolution ingQs = ingResults.next();
				for (String var : ingVars) {
					String result = ingQs.get(var).toString();
					ingredients.add(result.substring(result.indexOf('#')+1).trim());
				}
			}
			// Important - free up resources used running the query
			qe.close();
			
			for(int j=0; j<ingredients.size(); j++) {
				if(ingredients.get(j).equals(foodName)) {
					dish.add(classes.get(i));
				}
			}
		}
		return dish;
	}
	
	public ArrayList<String> getIngredient(String dishName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasIngredients; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+dishName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	public ArrayList<String> getIntakeTimeForDish(String dishName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasIntakeTime; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+dishName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getIntakeOthers(String foodName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasIntakeTime; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	public ArrayList<String> getPurposeOthers(String foodName){
		ArrayList<String> classes = new ArrayList<String>();
		//ArrayList<String> subclasses = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT  ?dataRange "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf ?restriction . "
				+ " ?restriction owl:onProperty mo:hasPurpose; "
				+ " owl:someValuesFrom ?dataRange. "
				+ " FILTER(?subClass = mo:"+foodName+") "
				+ " }";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		return classes;
	}
	
	/** 
	 * Retrieving dishes and food based on the intake time
	 * @param indicator
	 * @param intake
	 * @return
	 */
	public ArrayList<String> getFoodsForIntake(String intake) {
			
		ArrayList<String> all = getAllIntakes();
		ArrayList<String> dishFood = new ArrayList<String>();
		ArrayList<String> intakes = new ArrayList<String>();
		
		for(int i=0;i<all.size();i++) {
			dishFood.add(i,all.get(i).substring(0,all.get(i).indexOf("#")).trim());
			intakes.add(i,all.get(i).substring(all.get(i).indexOf("#")+1).trim());
		}
		
		ArrayList<String> dishIntake = new ArrayList<String>();
		for(int i=0;i<dishFood.size();i++) {
			if(intakes.get(i).equals(intake)) {
				dishIntake.add(dishFood.get(i));
			}
		}
		return dishIntake;
	}
	
	public ArrayList<String> getFoodsForPreparation(String indicator, String method){
		ArrayList<String> food = new ArrayList<String>();
		
		//Process of searching of food/dish that matches the lists of food/dish and put it in food arraylist
		if(indicator.equals("food")) {
			//Process of separating the food list and the preparation methods accordingly to the index number
			ArrayList<String> all = getAllPreparations();
			ArrayList<String> dishFood = new ArrayList<String>();
			ArrayList<String> preps = new ArrayList<String>();
			for(int i=0;i<all.size();i++) {
				dishFood.add(i,all.get(i).substring(0,all.get(i).indexOf("#")).trim());
				preps.add(i,all.get(i).substring(all.get(i).indexOf("#")+1).trim());
			}
			
		
		
			
			//Get all allowed foods
			ArrayList<String> allFoods = getAllAllowedFoods();
			//Compare list of food with current food/dish index
			for(String f : allFoods) {
				for(int i=0;i<dishFood.size();i++) {
					if(dishFood.get(i).equals(f)) {
						if(preps.get(i).equals(method)) {
							food.add(dishFood.get(i));
						}
					}
				}
			}
			
			
		}else {
			
			food = getPurposeOthers(method);
		}
		
		return food;
		
	}
	
	/**
	 * get all dishes
	 * @return
	 */
	public ArrayList<String> getAllDishes() {
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> allMeats = new ArrayList<String>();
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT DISTINCT ?subClass "
				+ " WHERE { "
				+ " ?subClass rdfs:subClassOf mo:Dish "
				+ " } ";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			for (String var : vars) {
				String result = qs.get(var).toString();
				classes.add(result.substring(result.indexOf('#')+1).trim());
			}
		}
		// Important - free up resources used running the query
		qe.close();
		
		// get all subclass of Meats, now start real process.
		// idea daripada breadth first search
		while (classes.size() > 0) {
			String nextToTry = classes.get(0);
			ArrayList<String> subClasses = getAllSubclasses(nextToTry);
			
			if (subClasses.size() == 0) {
				// no more subclasses, it is the Food objects
				allMeats.add(nextToTry);
				classes.remove(0);
			}
			else {
				// have subclasses, take all of them as next candidate
				classes.addAll(subClasses);
				classes.remove(0);
			}
		}
		
		return allMeats;
	}
	
	/**
	 * get all allowed food
	 */
	
	public ArrayList<String> getAllAllowedFoods(){
		ArrayList<String> allAllowed = new ArrayList<String>();
		
		ArrayList<String> allowedHerbs = getAllAllowedHerbs();
		for(String herbs : allowedHerbs) {
			allAllowed.add(herbs);
		}
		
		ArrayList<String> allowedFruits = getAllAllowedFruits();
		for(String fruits : allowedFruits) {
			allAllowed.add(fruits);
		}
		
		ArrayList<String> allowedMeats = getAllAllowedMeats();
		for(String meats : allowedMeats) {
			allAllowed.add(meats);
		}
		
		ArrayList<String> allowedVegetables = getAllAllowedVegetables();
		for(String veges : allowedVegetables) {
			allAllowed.add(veges);
		}
		
		ArrayList<String> allowedOthers = getAllAllowedOthers();
		for(String others : allowedOthers) {
			allAllowed.add(others);
		}
		
		return allAllowed;
	}
	
	/**
	 * get all intake time
	 * @return
	 */
	public ArrayList<String> getAllIntakes() {
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT ?subClass ?dataRange "
				+ " WHERE { "
				+ " ?subClass ?predicate ?object. "
				+ " ?object owl:onProperty mo:hasIntakeTime; "
				+ " owl:someValuesFrom ?dataRange. "
				+ "}";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		ArrayList<String> restrictions = new ArrayList<String>();
		
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			String result = qs.get(vars.get(0)).toString();
			String food = result.substring(result.indexOf('#')+1).trim();
			result = qs.get(vars.get(1)).toString();
			String res = result.substring(result.indexOf('#')+1).trim();
			String combined = food.concat("#"+res);
			restrictions.add(combined);
		}
		
		// Important - free up resources used running the query
		qe.close();
		
		return restrictions;
	}
	
public ArrayList<String> getAllPreparations() {
		
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ " PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ " PREFIX mo: <http://www.semanticweb.org/ontologies/2013/2/OntologyMalayIndigenousHealthKnowledge.owl#> "
				+ " SELECT ?subClass ?dataRange "
				+ " WHERE { "
				+ " ?subClass ?predicate ?object. "
				+ " ?object owl:onProperty mo:hasPreparationMethod; "
				+ " owl:someValuesFrom ?dataRange. "
				+ "}";
		
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		
		ResultSet results = qe.execSelect();
		List<String> vars = results.getResultVars();
		ArrayList<String> restrictions = new ArrayList<String>();
		
		while (results.hasNext()) {
			QuerySolution qs = results.next();
			String result = qs.get(vars.get(0)).toString();
			String food = result.substring(result.indexOf('#')+1).trim();
			result = qs.get(vars.get(1)).toString();
			String res = result.substring(result.indexOf('#')+1).trim();
			String combined = food.concat("#"+res);
			restrictions.add(combined);
		}
		
		// Important - free up resources used running the query
		qe.close();
		
		return restrictions;
	}

	
}