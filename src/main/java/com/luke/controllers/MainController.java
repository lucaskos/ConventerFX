package com.luke.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainController {

	private String selectedRadioButtonText;
	private static String DEFAULT = null;

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
				setLabelText(labelTemperatureList, newValue);
			}

		});
	}
	private void getDefaultValue() {
		RadioButton tempRadioButton = (RadioButton) comboBoxElements.getChildren().get(0);
		DEFAULT = tempRadioButton.getText();
	}

	/*
	 * In initialize() method we give a List<Label> and add all the elements
	 * (including all temperature Labels in 2nd row of gridPane. Then we pass
	 * value to those Label using native method of setText on each.
	 */
	// TODO calculate those label according to chosen option
	private void setLabelText(List<Label> list, Number value) {
		int tempValue = Math.round(value.floatValue());
		for (Label l : list) {
			l.setText(String.valueOf(tempValue));
			if (selectedRadioButtonText != null) {
				System.out.println(selectedRadioButtonText);
			}
		}
	}

	@FXML
	void comboBoxSelected(ActionEvent event) {
		RadioButton selectedRadioButton = (RadioButton) event.getSource();
		selectedRadioButtonText = selectedRadioButton.getText();
	}

}
