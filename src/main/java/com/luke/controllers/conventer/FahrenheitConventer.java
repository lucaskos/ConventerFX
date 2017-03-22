package com.luke.controllers.conventer;

public class FahrenheitConventer implements TemperatureStrategy {

	@Override
	public ConversionResults convert(int value) {
		Float a = ((value - 32) * (5f / 9f));
		int celsius = Math.round(a);
		int kelvin = (int) (celsius + 235.15);
		return new ConversionResults(celsius, value, kelvin);
	}

}
