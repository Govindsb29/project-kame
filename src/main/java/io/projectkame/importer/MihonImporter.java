package io.projectkame.importer;

import io.projectkame.backup.BackupExplorer;
import io.projectkame.backup.BackupReport;

import java.nio.file.Path;

public class MihonImporter {

    private final BackupExplorer explorer = new BackupExplorer();

    public BackupReport importBackup(Path backupFile) throws Exception {

        return explorer.explore(backupFile);

    }

}