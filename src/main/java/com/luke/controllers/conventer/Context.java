package com.luke.controllers.conventer;

public class Context {
	private TemperatureStrategy strategy;

	public Context(TemperatureStrategy strategy) {
		this.strategy = strategy;
	}
	
	public ConversionResults convert(int value) {
		return strategy.convert(value);
	}
}
