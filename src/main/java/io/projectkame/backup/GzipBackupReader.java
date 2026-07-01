package io.projectkame.backup;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GzipBackupReader {

    public byte[] decompress(byte[] compressedData) throws IOException {

        try (
                ByteArrayInputStream input = new ByteArrayInputStream(compressedData);
                GZIPInputStream gzip = new GZIPInputStream(input);
                ByteArrayOutputStream output = new ByteArrayOutputStream()
        ) {

            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = gzip.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            return output.toByteArray();
        }
    }
}