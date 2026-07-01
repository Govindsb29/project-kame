package io.projectkame.backup;

public class BackupInspector {

    public boolean isGzip(byte[] bytes) {

        if (bytes.length < 2) {
            return false;
        }

        return bytes[0] == (byte) 0x1F
                && bytes[1] == (byte) 0x8B;

    }

}