package com.luke.controllers.conventers.weight;

import java.util.ArrayList;

public class ConversionWeighResults {

	private double kilogram;
	private double pound, ounce, stones;

	public ConversionWeighResults(double kilogram, double pound, double ounce, double stones) {
		this.kilogram = kilogram;
		this.pound = pound;
		this.ounce = ounce;
		this.stones = stones;
	}

	public double getKilogram() {
		return kilogram;
	}

	public void setKilogram(int kilogram) {
		this.kilogram = kilogram;
	}

	public double getPound() {
		return pound;
	}

	public void setPound(double pound) {
		this.pound = pound;
	}

	public double getOunce() {
		return ounce;
	}

	public void setOunce(double ounce) {
		this.ounce = ounce;
	}

	public double getStones() {
		return stones;
	}

	public void setStones(double stones) {
		this.stones = stones;
	}

	@Override
	public String toString() {
		return "ConversionWeighResults [getKilogram()=" + getKilogram() + ", getPound()=" + getPound() + ", getOunce()="
				+ getOunce() + ", getStones()=" + getStones() + "]";
	}
	
	public ArrayList<Number> getResults() {
		ArrayList<Number> temp = new ArrayList<>();
		temp.add(getKilogram());
		temp.add(getPound());
		temp.add(getOunce());
		temp.add(getStones());
		return temp;
	}
	

}
