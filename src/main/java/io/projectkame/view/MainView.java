package io.projectkame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class MainView {

    private final Parent root;

    public MainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/MainView.fxml")
        );

        root = loader.load();
    }

    public Parent getRoot() {
        return root;
    }
}