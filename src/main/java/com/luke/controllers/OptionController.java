package com.luke.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.PickResult;

public class OptionController {

	@FXML
	private Slider slider;

	public OptionController() {
		System.out.println("controlled initialized");
		PickResult pickResult;
		int i = (int) slider.getValue();
		System.out.println(i);

		slider.setOnDragDetected(e -> {
			System.out.println(e.getPickResult());
		});
		
		slider.setOnDragDetected(e -> {
			System.out.println(e.getPickResult());
		});
	}

}
