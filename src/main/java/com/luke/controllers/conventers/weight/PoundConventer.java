package com.luke.controllers.conventers.weight;

public class PoundConventer implements WeightStrategy {

	@Override
	public ConversionWeighResults convert(Number value) {
		double kilogram = value.doubleValue() * 0.45359237;
		double ounce = kilogram * 35.274;
		double stones = kilogram *  0.15747;
		return new ConversionWeighResults(kilogram, value.doubleValue(), ounce, stones);
		
	}

}
