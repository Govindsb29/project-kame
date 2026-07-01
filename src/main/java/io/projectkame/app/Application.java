package io.projectkame.app;

import io.projectkame.backup.*;

import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" Project Kame");
        System.out.println("================================");

        try {

            BackupExplorer explorer = new BackupExplorer();

            explorer.explore(
                    Path.of("samples/backup.tachibk")
            );

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }





    }

}