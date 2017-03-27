package com.luke.controllers.conventers.weight;

public class StoneConventer implements WeightStrategy {

	@Override
	public ConversionWeighResults convert(Number value) {
		
		double kilogram = value.doubleValue() /  0.15747;
		double ounce = value.doubleValue() * 224.00;
		double pound = value.doubleValue() * 14;
		return new ConversionWeighResults(kilogram, pound, ounce, value.doubleValue());
	}

}
