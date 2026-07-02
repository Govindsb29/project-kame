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

            StringBuilder sb = new StringBuilder();

            sb.append("File : ")
                    .append(report.fileName())
                    .append("\n\n");

            sb.append("Compressed Size : ")
                    .append(report.compressedSize())
                    .append(" bytes\n\n");

            sb.append("Decompressed Size : ")
                    .append(report.decompressedSize())
                    .append(" bytes\n\n");

            sb.append("GZIP : ")
                    .append(report.gzip() ? "Yes" : "No")
                    .append("\n\n");

            sb.append("Hex Preview\n");
            sb.append("-------------------------\n");
            sb.append(report.hexPreview())
                    .append("\n\n");

            sb.append("First Strings\n");
            sb.append("-------------------------\n");

            report.extractedStrings()
                    .forEach(s -> sb.append(s).append("\n"));

            status.set(sb.toString());

        } catch (Exception e) {

            status.set(e.getMessage());

        }
    }
}