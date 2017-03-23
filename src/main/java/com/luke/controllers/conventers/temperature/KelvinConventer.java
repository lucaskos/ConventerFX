package com.luke.controllers.conventers.temperature;

public class KelvinConventer implements TemperatureStrategy {

	@Override
	public ConversionResults convert(int value) {
		int celsius = (int) Math.round(value - 273.15d);
		float f = ((value) * 9f/5f - 459.67f);
		int fahrenheit = Math.round(f);
		return new ConversionResults(celsius, fahrenheit, value);
	}

}
