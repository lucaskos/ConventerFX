package com.luke.controllers.conventers.weight;

public class ContextWeigh {
	private WeighStrategy weightStrategy;
	
	public ContextWeigh(WeighStrategy strategy) {
		this.weightStrategy = strategy;
	}
	
	public ConversionWeighResults convert(int value) {
		return this.weightStrategy.convert(value);
	}
}
