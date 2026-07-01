package io.projectkame.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.nio.file.Path;

public class MainViewModel {

    private final StringProperty status =
            new SimpleStringProperty("No backup loaded.");

    public StringProperty statusProperty() {
        return status;
    }

    public void backupSelected(Path path) {
        status.set("Backup selected:\n" + path.getFileName());
    }
}