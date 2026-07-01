package io.projectkame.backup;

import io.projectkame.util.HexUtils;

import java.nio.file.Path;

public class BackupExplorer {

    private static final int HEX_PREVIEW_LENGTH = 32;
    private static final int STRING_PREVIEW_LIMIT = 20;

    public void explore(Path backupFile) throws Exception {

        BackupReader reader = new BackupReader();

        byte[] compressedBackup = reader.read(backupFile);

        System.out.println("Backup loaded successfully.");
        System.out.println("Size: " + compressedBackup.length + " bytes");

        BackupInspector inspector = new BackupInspector();

        System.out.println(
                "GZIP: " + inspector.isGzip(compressedBackup)
        );

        GzipBackupReader gzipReader = new GzipBackupReader();

        byte[] protobufData = gzipReader.decompress(compressedBackup);

        System.out.println(
                "Decompressed Size: " + protobufData.length + " bytes"
        );

        System.out.println();
        System.out.println("First 32 bytes:");

        System.out.println(
                HexUtils.firstBytes(protobufData, HEX_PREVIEW_LENGTH)
        );

        StringExtractor extractor = new StringExtractor();

        System.out.println();
        System.out.println("First 20 extracted strings:");

        extractor.extract(protobufData)
                .stream()
                .limit(STRING_PREVIEW_LIMIT)
                .forEach(System.out::println);
    }
}