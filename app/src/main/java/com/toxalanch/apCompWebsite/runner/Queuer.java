package com.toxalanch.apCompWebsite.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Queuer implements AutoCloseable{
    Path path;

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Queuer)) {
            return false;
        }
        Queuer other = (Queuer) o;
        return path.equals(other.path);
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (path != null) {
            result = 31 * result + path.hashCode();
        }
        return result;
    }

    public void close() {
        try (Stream<Path> paths = Files.walk(this.path)) {
            paths.sorted(Comparator.reverseOrder())
            .forEach(patha -> {
                try {
                    Files.delete(patha);
                } catch (IOException e) {
                    System.err.println("Failed to delete: " + patha.toString());
                }
            });
        } catch (IOException e) {
            System.err.println("Failed to delete: " + path.toString());
        }
    }
}