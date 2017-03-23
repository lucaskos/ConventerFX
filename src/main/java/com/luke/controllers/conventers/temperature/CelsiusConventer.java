package com.luke.controllers.conventers.temperature;

public class CelsiusConventer implements TemperatureStrategy {

	@Override
	public ConversionResults convert(int value) {
		int kelvin = (int) Math.round(value + 273.15);
		int fahrenheit = (int) Math.round(value * 1.8 + 32); 
		return new ConversionResults(value, fahrenheit, kelvin);
		
	}

}
