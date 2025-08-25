package com.example.algovisualizer.ui;

import com.example.algovisualizer.SortingVisualizer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class SortingPane extends BorderPane {
    private static final int NUM_BARS = 50;
    private Rectangle[] bars;
    private SortingVisualizer visualizer;

    public SortingPane() {
        Pane barsPane = new Pane();
        barsPane.setPrefSize(800, 500);

        bars = new Rectangle[NUM_BARS];
        Random rand = new Random();

        for (int i = 0; i < NUM_BARS; i++) {
            double height = rand.nextInt(400) + 50;
            Rectangle bar = new Rectangle(i * (800.0 / NUM_BARS), 500 - height,
                    (800.0 / NUM_BARS) - 2, height);
            bar.setFill(Color.BLUE);
            bars[i] = bar;
            barsPane.getChildren().add(bar);
        }

        visualizer = new SortingVisualizer(bars);

        Button bubbleSortBtn = new Button("Bubble Sort");
        bubbleSortBtn.setOnAction(e -> visualizer.bubbleSort());

        Button insertionSortBtn = new Button("Insertion Sort");
        insertionSortBtn.setOnAction(e -> visualizer.insertionSort());

        Button resetBtn = new Button("Reset");
        resetBtn.setOnAction(e -> resetBars(barsPane));

        HBox controls = new HBox(10, bubbleSortBtn, insertionSortBtn, resetBtn);
        controls.setAlignment(Pos.CENTER);
        controls.setStyle("-fx-padding: 10;");

        this.setCenter(barsPane);
        this.setBottom(controls);
    }

    private void resetBars(Pane barsPane) {
        barsPane.getChildren().clear();
        Random rand = new Random();

        for (int i = 0; i < NUM_BARS; i++) {
            double height = rand.nextInt(400) + 50;
            Rectangle bar = new Rectangle(i * (800.0 / NUM_BARS), 500 - height,
                    (800.0 / NUM_BARS) - 2, height);
            bar.setFill(Color.BLUE);
            bars[i] = bar;
            barsPane.getChildren().add(bar);
        }

        visualizer = new SortingVisualizer(bars);
    }
}
