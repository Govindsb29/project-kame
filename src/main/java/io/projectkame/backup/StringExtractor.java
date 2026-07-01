package io.projectkame.backup;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringExtractor {

    public Set<String> extract(byte[] data) {

        Set<String> strings = new LinkedHashSet<>();

        StringBuilder current = new StringBuilder();

        for (byte b : data) {

            if (b >= 32 && b <= 126) {

                current.append((char) b);

            } else {

                if (current.length() >= 6) {
                    strings.add(current.toString());
                }

                current.setLength(0);
            }
        }

        if (current.length() >= 6) {
            strings.add(current.toString());
        }

        return strings;
    }
}