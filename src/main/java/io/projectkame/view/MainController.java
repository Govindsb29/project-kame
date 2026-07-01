package io.projectkame.view;

import io.projectkame.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {

    @FXML
    private Button openBackupButton;

    @FXML
    private Label statusLabel;

    private final MainViewModel viewModel = new MainViewModel();

    @FXML
    private void initialize() {

        statusLabel.textProperty().bind(viewModel.statusProperty());

        openBackupButton.setOnAction(event -> openBackup());
    }

    private void openBackup() {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Mihon Backup");

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Mihon Backup",
                        "*.tachibk"
                )
        );

        File file = chooser.showOpenDialog(
                openBackupButton.getScene().getWindow()
        );

        if (file != null) {
            viewModel.backupSelected(file.toPath());
        }
    }
}