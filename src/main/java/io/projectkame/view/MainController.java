package io.projectkame.view;

import io.projectkame.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {

    @FXML
    private Button openBackupButton;

    @FXML
    private TextArea statusArea;

    @FXML
    private Label statusLabel;

    @FXML
    private ListView<String> libraryList;

    @FXML
    private TextField searchField;

    private final MainViewModel viewModel = new MainViewModel();

    @FXML
    private void initialize() {

        statusArea.textProperty().bind(viewModel.statusProperty());

        statusLabel.setText("Ready");

        openBackupButton.setOnAction(e -> openBackup());

        libraryList.getItems().add(
                "Library will appear here..."
        );
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

            statusLabel.setText(file.getName());

            libraryList.getItems().clear();

            libraryList.getItems().add("Loading...");

            viewModel.backupSelected(file.toPath());

        }

    }

}