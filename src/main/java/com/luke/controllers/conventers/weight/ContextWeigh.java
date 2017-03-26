package com.luke.controllers.conventers.weight;

public class ContextWeigh {
	private WeightStrategy weightStrategy;
	
	public ContextWeigh(WeightStrategy strategy) {
		this.weightStrategy = strategy;
	}
	
	public ConversionWeighResults convert(int value) {
		return this.weightStrategy.convert(value);
	}
}
