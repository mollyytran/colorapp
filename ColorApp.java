//Molly Tran
//CS 56 Section 1733
//Assignment 8- ColorApp

package com.example.colorapp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.geometry.Pos.CENTER;

public class ColorApp extends Application {

    // Text and scroll bars declaration
    private ScrollBar sbRed;
    private ScrollBar sbGreen;
    private ScrollBar sbBlue;
    private ScrollBar sbOpacity;
    private Label showColorLabel;

    @Override
    public void start(Stage stage) throws IOException {

        // Create text
        showColorLabel = new Label("Show Colors");

        // Create scrollbar objects
        sbRed = new ScrollBar();
        sbGreen = new ScrollBar();
        sbBlue = new ScrollBar();
        sbOpacity = new ScrollBar();

        // Initialize min and max of scroll bars
        sbRed.setMin(0.0);
        sbGreen.setMin(0.0);
        sbBlue.setMin(0.0);
        sbOpacity.setMin(0.0);
        sbRed.setMax(1.0);
        sbGreen.setMax(1.0);
        sbBlue.setMax(1.0);
        sbOpacity.setMax(1.0);


        // Create grid-pane and add scroll bars and labels
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(150, 100);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(CENTER);
        gridPane.add(showColorLabel, 0, 0, 2, 2);
        GridPane.setHalignment(showColorLabel, HPos.CENTER);
        gridPane.addRow(3, new Label("Red"), sbRed);
        gridPane.addRow(4, new Label("Green"), sbGreen);
        gridPane.addRow(5, new Label("Blue"), sbBlue);
        gridPane.addRow(6, new Label("Opacity"), sbOpacity);

        // Create borderpane and add text and gridpane
        BorderPane pane = new BorderPane();
        pane.setCenter(gridPane);

        // Create listener for scroll bars and updates values by calling updateLabelColor method
        sbRed.valueProperty().addListener((observableValue, oldValue, newValue) -> updateLabelColor());
        sbGreen.valueProperty().addListener((observableValue, oldValue, newValue) -> updateLabelColor());
        sbBlue.valueProperty().addListener((observableValue, oldValue, newValue) -> updateLabelColor());
        sbOpacity.valueProperty().addListener((observableValue, oldValue, newValue) -> updateLabelColor());
        sbOpacity.setValue(1.0);

        // Set scene and show stage
        Scene scene = new Scene(pane, 250, 200);
        stage.setTitle("Exercise16_17!");
        stage.setScene(scene);
        stage.show();
    }

    // Method to update color
    private void updateLabelColor() {
        Color color = Color.color(sbRed.getValue(),
                sbGreen.getValue(),
                sbBlue.getValue(),
                sbOpacity.getValue());
        showColorLabel.setTextFill(color);
    }

    public static void main (String[]args){
            launch();
        }
    }


