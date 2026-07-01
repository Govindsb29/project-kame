package io.projectkame.backup;

import java.util.List;

public record BackupReport(
        int compressedSize,
        int decompressedSize,
        boolean gzip,
        String hexPreview,
        List<String> extractedStrings
) {
}