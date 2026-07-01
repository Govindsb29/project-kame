package io.projectkame.backup;

import io.projectkame.util.HexUtils;

import java.nio.file.Path;
import java.util.List;

public class BackupExplorer {

    private static final int HEX_PREVIEW_LENGTH = 32;
    private static final int STRING_PREVIEW_LIMIT = 20;

    public BackupReport explore(Path backupFile) throws Exception {

        BackupReader reader = new BackupReader();

        byte[] compressedBackup = reader.read(backupFile);

        BackupInspector inspector = new BackupInspector();

        boolean gzip = inspector.isGzip(compressedBackup);

        GzipBackupReader gzipReader = new GzipBackupReader();

        byte[] protobufData = gzipReader.decompress(compressedBackup);

        String hexPreview = HexUtils.firstBytes(
                protobufData,
                HEX_PREVIEW_LENGTH
        );

        StringExtractor extractor = new StringExtractor();

        List<String> extractedStrings = extractor.extract(protobufData)
                .stream()
                .limit(STRING_PREVIEW_LIMIT)
                .toList();

        return new BackupReport(
                compressedBackup.length,
                protobufData.length,
                gzip,
                hexPreview,
                extractedStrings
        );
    }
}