package com.luke.controllers;

import java.util.ArrayList;
import java.util.List;

import com.luke.controllers.conventers.weight.ContextWeigh;
import com.luke.controllers.conventers.weight.ConversionWeighResults;
import com.luke.controllers.conventers.weight.KilogramConventer;
import com.sun.javafx.collections.ChangeHelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class WeightController {
	private ContextWeigh context;
	private static final String KILOGRAM_VALUE = "Kilogram";
	private static final String POUND_VALUE = "Pound";
	private static final String OUNCE_VALUE = "Ounce";
	private static final String STONES_VALUE = "Stones";

	ObservableList<String> weightValueList = FXCollections.observableArrayList(KILOGRAM_VALUE, POUND_VALUE, OUNCE_VALUE,
			STONES_VALUE);

	@FXML
	private Slider slider;

	@FXML
	private FlowPane weighPane;

	@FXML
	private Label ounceLabel;

	@FXML
	private Label kilogramResultLabel;

	@FXML
	private Label stonesLabel;

	@FXML
	private Label kilogramLabel;

	@FXML
	private Label ounceResultLabel;

	@FXML
	private ChoiceBox<String> temperatureChoiceBox;

	@FXML
	private Label poundLabel;

	@FXML
	private Label stonesResultLabel;

	@FXML
	private Label poundResultLabel;
	ConversionWeighResults convertionResults;
	ArrayList<Label> resultsLabel;
	
	//TODO extract this to method ?
	private String weightOption = KILOGRAM_VALUE;
	private int value = 0;
	
	@FXML
	public void initialize() {
		
		resultsLabel = new ArrayList<Label>();
		resultsLabel.add(kilogramResultLabel);
		resultsLabel.add(poundResultLabel);
		resultsLabel.add(ounceResultLabel);
		resultsLabel.add(stonesResultLabel);
		
		setDefaultLabelValues(resultsLabel, value);
		System.out.println("weight controller initialized");
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				value = newValue.intValue();
				System.out.println(weightOption);
				if(weightOption.equalsIgnoreCase(KILOGRAM_VALUE)) {
					context = new ContextWeigh(new KilogramConventer());
					convertionResults = context.convert(value);
					
					
					
					//TODO delete syso
					System.out.println("Value of the slider to kilogram : "+ convertionResults.toString());
				} else if (weightOption.equalsIgnoreCase(OUNCE_VALUE)) {
					
				} else if(weightOption.equalsIgnoreCase(POUND_VALUE)) {
					
				} else {
					
				}
			}
		});

		temperatureChoiceBox.setItems(weightValueList);
		temperatureChoiceBox.getSelectionModel().select(KILOGRAM_VALUE);
		temperatureChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				weightOption = newValue;
			}
		});
	}

	public void setDefaultLabelValues(ArrayList<Label> label, int value) {
		for(Label l : label) 
			l.setText(String.valueOf(value));
	}
	
	public void setLabelValues(ArrayList<Label> labelList, ConversionWeighResults rs) {
		for(int i = 0 ; i < labelList.size(); i++){
			labelList.get(i).setText(String.valueOf(rs.getResults().get(i)));
		}
	}
	
	public WeightController() {
		

	}
}
