package io.projectkame.backup;

import java.util.List;

public record BackupReport(
        String fileName,
        int compressedSize,
        int decompressedSize,
        boolean gzip,
        String hexPreview,
        List<String> extractedStrings
) {
}