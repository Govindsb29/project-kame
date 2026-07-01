package io.projectkame.util;

public final class HexUtils {

    private HexUtils() {
    }

    public static String firstBytes(byte[] data, int count) {

        StringBuilder builder = new StringBuilder();

        int length = Math.min(count, data.length);

        for (int i = 0; i < length; i++) {

            builder.append(
                    String.format("%02X ", data[i])
            );

        }

        return builder.toString();

    }

}