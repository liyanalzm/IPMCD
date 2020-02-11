package mc.vo;

import java.util.ArrayList;

public class Food {

	private String foodName;
	private ArrayList<String> reasons;
	private ArrayList<String> enhance;
	private ArrayList<String> phytochemical;
	private String pyramidLevel;
	private String restriction;
	private String colour;
	private ArrayList<String> intake;
	private ArrayList<String> combinations;
	private ArrayList<String> preparations;
	private ArrayList<String> ingredients;
	
	public ArrayList<String> getIntake() {
		return intake;
	}
	public void setIntake(ArrayList<String> intake) {
		this.intake = intake;
	}
	public ArrayList<String> getCombinations() {
		return combinations;
	}
	public void setCombinations(ArrayList<String> combinations) {
		this.combinations = combinations;
	}
	public ArrayList<String> getPreparations() {
		return preparations;
	}
	public void setPreparations(ArrayList<String> preparations) {
		this.preparations = preparations;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public ArrayList<String> getReasons() {
		return reasons;
	}
	public void setReasons(ArrayList<String> reasons) {
		this.reasons = reasons;
	}
	public ArrayList<String> getEnhance() {
		return enhance;
	}
	public void setEnhance(ArrayList<String> enhance) {
		this.enhance = enhance;
	}
	public ArrayList<String> getPhytochemical() {
		return phytochemical;
	}
	public void setPhytochemical(ArrayList<String> phytochemical) {
		this.phytochemical = phytochemical;
	}
	public String getPyramidLevel() {
		return pyramidLevel;
	}
	public void setPyramidLevel(String pyramidLevel) {
		this.pyramidLevel = pyramidLevel;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

}
