package io.projectkame.view;

import io.projectkame.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {

    @FXML
    private Button openBackupButton;

    @FXML
    private TextArea statusArea;

    private final MainViewModel viewModel = new MainViewModel();

    @FXML
    private void initialize() {

        statusArea.textProperty().bind(viewModel.statusProperty());

        openBackupButton.setOnAction(e -> openBackup());
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