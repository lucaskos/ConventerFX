package com.luke.controllers.conventers.weight;

public class KilogramConventer implements WeightStrategy  {

	@Override
	//takes kilogram as a value and returns all 4 value as a object
	public ConversionWeighResults convert(Number value) {
		double pound = value.doubleValue() / 0.45359237;
		double stones = value.doubleValue() *  0.15747;
		double ounce = value.doubleValue() * 35.274;
		return new ConversionWeighResults(value.doubleValue(), pound, ounce, stones);
	}

}
