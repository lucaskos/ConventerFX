package com.luke.controllers.conventer;

public class ConversionResults {
	private int celsius, fahrenheit, kelvin;

	public ConversionResults(int celsius, int fahrenheit, int kelvin) {
		this.celsius = celsius;
		this.fahrenheit = fahrenheit;
		this.kelvin = kelvin;
	}

	public int getCelsius() {
		return celsius;
	}

	public void setCelsius(int celsius) {
		this.celsius = celsius;
	}

	public int getFahrenheit() {
		return fahrenheit;
	}

	public void setFahrenheit(int fahrenheit) {
		this.fahrenheit = fahrenheit;
	}

	public int getKelvin() {
		return kelvin;
	}

	public void setKelvin(int kelvin) {
		this.kelvin = kelvin;
	}

	@Override
	public String toString() {
		return "ConversionResults [celsius=" + celsius + ", fahrenheit=" + fahrenheit + ", kelvin=" + kelvin + "]";
	}
	
	

}
