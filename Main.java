package com.example.algovisualizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.algovisualizer.ui.SortingPane;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        SortingPane root = new SortingPane();
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("AlgoVisualizer - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
