package io.projectkame.library;

public class Entry {

    private final String title;

    public Entry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}