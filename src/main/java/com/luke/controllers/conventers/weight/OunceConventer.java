package com.luke.controllers.conventers.weight;

public class OunceConventer implements WeightStrategy {

	@Override
	public ConversionWeighResults convert(int value) {
		int kilogram = (int) (value * 35.274);
		double pound = value * 0.0625;
		System.out.println(pound);
		double stones = value * 0.0044643;
		return new ConversionWeighResults(kilogram, pound, value, stones);
	}

}
