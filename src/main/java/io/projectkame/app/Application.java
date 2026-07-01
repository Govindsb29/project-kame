package io.projectkame.app;

import io.projectkame.backup.BackupInspector;
import io.projectkame.backup.BackupReader;
import io.projectkame.backup.GzipBackupReader;
import io.projectkame.backup.StringExtractor;
import io.projectkame.util.HexUtils;

import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" Project Kame");
        System.out.println("================================");

        try {

            BackupReader reader = new BackupReader();

            byte[] compresseedBackup = reader.read(
                    Path.of("samples/backup.tachibk")
            );

            System.out.println("Backup loaded successfully.");
            System.out.println("Size: " + compresseedBackup.length + " bytes");

            BackupInspector inspector = new BackupInspector();

            System.out.println(
                    "GZIP: " + inspector.isGzip(compresseedBackup)
            );

            GzipBackupReader gzipReader = new GzipBackupReader();

            byte[] protobufData = gzipReader.decompress(compresseedBackup);

            System.out.println(
                    "Decompressed Size: " + protobufData.length + " bytes"
            );

            System.out.println();
            System.out.println("First 32 bytes:");

            System.out.println(
                    HexUtils.firstBytes(protobufData, 32)
            );

            StringExtractor extractor = new StringExtractor();

            System.out.println();
            System.out.println("First 20 extracted strings:");

            extractor.extract(protobufData)
                    .stream()
                    .limit(20)
                    .forEach(System.out::println);

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }





    }

}