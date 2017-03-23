package com.luke.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainApp.fxml"));
		TabPane pane = loader.load();
		Scene scene = new Scene(pane); 
		stage.setScene(scene);
		stage.setTitle("ConventerFX");
		stage.show();
	}

}
