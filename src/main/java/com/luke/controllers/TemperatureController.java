package com.luke.controllers;

import java.util.ArrayList;
import java.util.List;

import com.luke.controllers.conventers.temperature.CelsiusConventer;
import com.luke.controllers.conventers.temperature.Context;
import com.luke.controllers.conventers.temperature.ConversionResults;
import com.luke.controllers.conventers.temperature.FahrenheitConventer;
import com.luke.controllers.conventers.temperature.KelvinConventer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TemperatureController {

	private String selectedRadioButtonText;
	private static String DEFAULT = null;
	private static final String celsius = "celsius", fahrenheit = "fahrenheit", kelvin = "kelvin";
	protected static ConversionResults results = null;

	@FXML // fx:id="kelvinLabel"
	private Label kelvinLabel; // Value injected by FXMLLoader

	@FXML // fx:id="fahrenheitLabel"
	private Label fahrenheitLabel; // Value injected by FXMLLoader

	@FXML // fx:id="celsiusLabel"
	private Label celsiusLabel; // Value injected by FXMLLoader

	@FXML
	private Slider slider;

	@FXML // fx:id="comboBoxElements"
	private VBox comboBoxElements; // Value injected by FXMLLoader

	private List<Label> labelTemperatureList;
	private Context context;
	private ConversionResults convertResults;

	@FXML
	public void initialize() {
		System.out.println("initialized");
		getDefaultValue();
		selectedRadioButtonText = DEFAULT;

		labelTemperatureList = new ArrayList<Label>();
		labelTemperatureList.add(celsiusLabel);
		labelTemperatureList.add(fahrenheitLabel);
		labelTemperatureList.add(kelvinLabel);

		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (selectedRadioButtonText.equals(celsius)) {
					context = new Context(new CelsiusConventer());
					convertResults = context.convert(newValue.intValue());
					setLabelText(convertResults);
                                        setDefaultLabelColors();
					celsiusLabel.setTextFill(Color.web("red"));

				} else if (selectedRadioButtonText.equalsIgnoreCase(fahrenheit)) {
					context = new Context(new FahrenheitConventer());
					convertResults = context.convert(newValue.intValue());
					setLabelText(convertResults);
                                        setDefaultLabelColors();
                                        fahrenheitLabel.setTextFill(Color.web("red"));

				} else {
					context = new Context(new KelvinConventer());
					convertResults = context.convert(newValue.intValue());
					setLabelText(convertResults);
                                        setDefaultLabelColors();
                                        kelvinLabel.setTextFill(Color.web("red"));
				}
			}

		});
	}

	// setting up default selected value as 'celsius'
	private void getDefaultValue() {
		RadioButton tempRadioButton = (RadioButton) comboBoxElements.getChildren().get(0);
		DEFAULT = tempRadioButton.getText();
	}private void setDefaultLabelColors() {
            Color defaultColor = Color.web("black");
            celsiusLabel.setTextFill(defaultColor);
            fahrenheitLabel.setTextFill(defaultColor);
            kelvinLabel.setTextFill(defaultColor);
        }

	/*
	 * In initialize() method we give a List<Label> and add all the elements
	 * (including all temperature Labels in 2nd row of gridPane. Then we pass
	 * value to those Label using native method of setText on each.
	 */
	// TODO calculate those label according to chosen option
	private void setLabelText(ConversionResults r) {
		celsiusLabel.setText(String.valueOf(r.getCelsius()));
		fahrenheitLabel.setText(String.valueOf(r.getFahrenheit()));
		kelvinLabel.setText(String.valueOf(r.getKelvin()));
	}

	// getting text of selected radiobutton
	@FXML
	void comboBoxSelected(ActionEvent event) {
		RadioButton selectedRadioButton = (RadioButton) event.getSource();
		selectedRadioButtonText = selectedRadioButton.getText();
	}
	

}
