package javaFX;

import HikingApplication.HikingTrail;
import HikingApplication.HikingTrailApp;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class HikingTrailUI extends Application {
	private ArrayList<HikingTrail> trails; // Stores the trails
	private static ArrayList<HikingTrail> trailData = new ArrayList<>();
	private TextArea displayArea; // Text will display the data here

	public HikingTrailUI() {
		this.trails = new ArrayList<>(trailData); // Initialize an empty list
	}

	@Override
	public void start(Stage primaryStage) {
		// Set up for the GUI
		VBox layout = new VBox(10);
		layout.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-spacing: 15;");

		displayArea = new TextArea();
		// Text area to display output
		displayArea.setEditable(false);
		displayArea.setWrapText(true);
		displayArea.setPrefHeight(400);

		// Buttons for menu options
		Button displayOriginalOrder = new Button("Display Trails in Original Order");
		Button displaySortedOrder = new Button("Display Trails in Sorted Order");
		Button displayRandomOrder = new Button("Display Trails in Random Order");
		Button exit = new Button("Exit");

		// Add button actions
		displayOriginalOrder.setOnAction(event -> displayOriginalOrder());
		displaySortedOrder.setOnAction(event -> displaySortedOrder());
		displayRandomOrder.setOnAction(event -> displayRandomOrder());
		exit.setOnAction(event -> primaryStage.close());

		// Add buttons to an HBox
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(displayOriginalOrder, displaySortedOrder, displayRandomOrder, exit);

		// Add all components to the layout
		layout.getChildren().addAll(buttonBox, displayArea);

		// Create the scene
		Scene scene = new Scene(layout, 700, 500);
		primaryStage.setTitle("Hiking Trail Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void displayOriginalOrder() {
		displayArea.clear();
		if (trails.isEmpty()) {
			displayArea.appendText("No trails available to display.\n");
			return;
		}
		for (HikingTrail trail : trails) {
			displayArea.appendText(trail.toString() + "\n");
		}
	}

	private void displaySortedOrder() {
		displayArea.clear();
		if (trails.isEmpty()) {
			displayArea.appendText("No trails available to display.\n");
			return;
		}
		ArrayList<HikingTrail> sortedTrails = new ArrayList<>(trails);
		Collections.sort(sortedTrails);
		for (HikingTrail trail : sortedTrails) {
			displayArea.appendText(trail.toString() + "\n");
		}
	}

	private void displayRandomOrder() {
		displayArea.clear();
		if (trails.isEmpty()) {
			displayArea.appendText("No trails available to display.\n");
			return;
		}
		ArrayList<HikingTrail> randomTrails = new ArrayList<>(trails);
		Collections.shuffle(randomTrails);
		for (HikingTrail trail : randomTrails) {
			displayArea.appendText(trail.toString() + "\n");
		}
	}

	public static void main(String[] args) {
		Application.launch(HikingTrailUI.class, args);
	}
}