package com.luke.controllers.conventers.weight;

public class KilogramConventer implements WeightStrategy  {

	@Override
	//takes kilogram as a value and returns all 4 value as a object
	public ConversionWeighResults convert(int value) {
		double pound = value / 0.45359237;
		double stones = value *  0.15747;
		double ounce = value * 35.274;
		return new ConversionWeighResults(value, pound, ounce, stones);
	}

}
