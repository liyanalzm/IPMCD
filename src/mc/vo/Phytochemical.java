package mc.vo;

import java.util.ArrayList;

public class Phytochemical {

	private String phytochemicalName;
	private ArrayList<String> phytochemical;
	private ArrayList<String> benefit;
	private ArrayList<String> property;
	private String colour;


	public String getPhytochemicalName() {
		return phytochemicalName;
	}
	public void setPhytochemicalName(String phytochemicalName) {
		this.phytochemicalName = phytochemicalName;
	}
	public ArrayList<String> getPhytochemical() {
		return phytochemical;
	}
	public void setPhytochemical(ArrayList<String> phytochemical) {
		this.phytochemical = phytochemical;
	}
	public ArrayList<String> getBenefit() {
		return benefit;
	}
	public void setBenefit(ArrayList<String> benefit) {
		this.benefit = benefit;
	}
	public ArrayList<String> getProperty() {
		return property;
	}
	public void setProperty(ArrayList<String> property) {
		this.property = property;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	

}
