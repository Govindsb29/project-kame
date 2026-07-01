package io.projectkame.viewmodel;

import io.projectkame.backup.BackupExplorer;
import io.projectkame.backup.BackupReport;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.nio.file.Path;

public class MainViewModel {

    private final StringProperty status =
            new SimpleStringProperty("No backup loaded.");

    private final BackupExplorer explorer = new BackupExplorer();

    public StringProperty statusProperty() {
        return status;
    }

    public void backupSelected(Path path) {

        try {

            BackupReport report = explorer.explore(path);

            StringBuilder builder = new StringBuilder();

            builder.append("Compressed Size : ")
                    .append(report.compressedSize())
                    .append(" bytes\n\n");

            builder.append("Decompressed Size : ")
                    .append(report.decompressedSize())
                    .append(" bytes\n\n");

            builder.append("GZIP : ")
                    .append(report.gzip() ? "Yes" : "No")
                    .append("\n\n");

            builder.append("First Strings\n");
            builder.append("----------------------\n");

            report.extractedStrings()
                    .forEach(s -> builder.append(s).append("\n"));

            status.set(builder.toString());

        } catch (Exception e) {

            status.set("Failed to load backup.\n\n" + e.getMessage());

        }
    }
}