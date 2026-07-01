package io.projectkame.app;

import io.projectkame.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectKameApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        MainView mainView = new MainView();

        Scene scene = new Scene(mainView.getRoot(), 900, 650);

        stage.setTitle("Project Kame");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}