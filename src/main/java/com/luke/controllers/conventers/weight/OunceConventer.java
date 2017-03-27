package com.luke.controllers.conventers.weight;

public class OunceConventer implements WeightStrategy {

	@Override
	public ConversionWeighResults convert(Number value) {
		double kilogram = value.doubleValue() * 35.274;
		double pound = value.doubleValue() * 0.0625;
		double stones = value.doubleValue() * 0.0044643;
		return new ConversionWeighResults(kilogram, pound, value.doubleValue(), stones);
	}

}
