package com.example.algovisualizer;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SortingVisualizer {
    private Rectangle[] bars;

    public SortingVisualizer(Rectangle[] bars) {
        this.bars = bars;
    }

    // Swap two bars
    private void swap(int i, int j) {
        double tempHeight = bars[i].getHeight();
        bars[i].setHeight(bars[j].getHeight());
        bars[j].setHeight(tempHeight);
    }

    // Bubble Sort visualization
    public void bubbleSort() {
        new Thread(() -> {
            try {
                for (int i = 0; i < bars.length - 1; i++) {
                    for (int j = 0; j < bars.length - i - 1; j++) {
                        final int idx = j;
                        Platform.runLater(() -> bars[idx].setFill(Color.RED));
                        Thread.sleep(100);

                        if (bars[j].getHeight() > bars[j + 1].getHeight()) {
                            Platform.runLater(() -> swap(idx, idx + 1));
                        }

                        Platform.runLater(() -> bars[idx].setFill(Color.BLUE));
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Insertion Sort visualization
    public void insertionSort() {
        new Thread(() -> {
            try {
                for (int i = 1; i < bars.length; i++) {
                    double key = bars[i].getHeight();
                    int j = i - 1;

                    while (j >= 0 && bars[j].getHeight() > key) {
                        int finalJ = j;
                        Platform.runLater(() -> bars[finalJ + 1].setHeight(bars[finalJ].getHeight()));
                        j--;
                        Thread.sleep(150);
                    }

                    int finalI = i;
                    int finalJ1 = j;
                    Platform.runLater(() -> bars[finalJ1 + 1].setHeight(key));
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
