package io.projectkame.viewmodel;

import io.projectkame.backup.BackupReport;
import io.projectkame.importer.MihonImporter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.nio.file.Path;

public class MainViewModel {

    private final StringProperty status =
            new SimpleStringProperty("No backup loaded.");

    private final MihonImporter importer =
            new MihonImporter();

    public StringProperty statusProperty() {
        return status;
    }

    public void backupSelected(Path path) {

        try {

            BackupReport report =
                    importer.importBackup(path);

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

            sb.append("First Strings")
                    .append("\n")
                    .append("-------------------------")
                    .append("\n");

            report.extractedStrings()
                    .forEach(s -> sb.append(s).append("\n"));

            status.set(sb.toString());

        } catch (Exception e) {

            status.set(e.getMessage());

        }

    }

}