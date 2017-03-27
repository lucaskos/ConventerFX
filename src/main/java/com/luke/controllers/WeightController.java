package com.luke.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.luke.controllers.conventers.weight.ContextWeigh;
import com.luke.controllers.conventers.weight.ConversionWeighResults;
import com.luke.controllers.conventers.weight.KilogramConventer;
import com.luke.controllers.conventers.weight.OunceConventer;
import com.luke.controllers.conventers.weight.PoundConventer;
import com.luke.controllers.conventers.weight.StoneConventer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
	ConversionWeighResults conversionResults;
	ArrayList<Label> resultsLabel;
	
	//TODO extract this to method ?
	private String weightOption = KILOGRAM_VALUE;
	private Number value = 0;
	
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
				value = newValue;
				if(weightOption.equalsIgnoreCase(KILOGRAM_VALUE)) {
					context = new ContextWeigh(new KilogramConventer());
					conversionResults = context.convert(value);
					setLabelValues(resultsLabel, conversionResults);
				} else if (weightOption.equalsIgnoreCase(OUNCE_VALUE)) {
					context = new ContextWeigh(new OunceConventer());
					conversionResults = context.convert(value);
					setLabelValues(resultsLabel, conversionResults);
				} else if(weightOption.equalsIgnoreCase(POUND_VALUE)) {
					context = new ContextWeigh(new PoundConventer());
					conversionResults = context.convert(value);
					setLabelValues(resultsLabel, conversionResults);
				} else if(weightOption.equalsIgnoreCase(STONES_VALUE)) {
					context = new ContextWeigh(new StoneConventer());
					conversionResults = context.convert(value);
					setLabelValues(resultsLabel, conversionResults);

				} else {
					//TODO test dialog for wrong option
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Wrong Option");
					alert.setHeaderText(null);
					alert.setContentText("I have a great message for you!");
					alert.showAndWait();
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

	public void setDefaultLabelValues(ArrayList<Label> label, Number value) {
		for(Label l : label) 
			l.setText(String.valueOf(value));
	}
	
	public void setLabelValues(ArrayList<Label> labelList, ConversionWeighResults rs) {
		for(int i = 0 ; i < labelList.size(); i++){
			DecimalFormat formatter = new DecimalFormat("#0.00");
			labelList.get(i).setText(formatter.format(rs.getResults().get(i)));
		}
	}
	
}
