package io.projectkame.backup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BackupReader {

    public byte[] read(Path backupFile) throws IOException {

        if (!Files.exists(backupFile)) {
            throw new IOException("Backup file not found: " + backupFile);
        }

        return Files.readAllBytes(backupFile);
    }

}