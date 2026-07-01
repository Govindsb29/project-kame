package io.projectkame.app;

import io.projectkame.backup.BackupReader;

import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" Project Kame");
        System.out.println("================================");

        try {

            BackupReader reader = new BackupReader();

            byte[] data = reader.read(
                    Path.of("samples/backup.tachibk")
            );

            System.out.println("Backup loaded successfully.");
            System.out.println("Size: " + data.length + " bytes");

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

    }

}