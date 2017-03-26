package com.luke.controllers.conventers.weight;

public class PoundConventer implements WeightStrategy {

	@Override
	public ConversionWeighResults convert(int value) {
		int kilogram = (int) (value * 0.45359237);
		double ounce = kilogram * 35.274;
		double stones = kilogram *  0.15747;
		double pound = value;
		return new ConversionWeighResults(kilogram, pound, ounce, stones);
		
	}

}
