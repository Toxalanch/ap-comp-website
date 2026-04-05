package com.toxalanch.apCompWebsite.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class QueueObject implements AutoCloseable{
    private Path path;

    public QueueObject(Path path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof QueueObject)) {
            return false;
        }
        QueueObject other = (QueueObject) o;
        return path.equals(other.path);
    }

    @Override
    public int hashCode() {
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

    public String findClass() {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.filter(Files::isRegularFile)
            .filter(path -> {
                try (Stream<String> lines = Files.lines(path)) {
                    return lines.anyMatch(line -> line.toLowerCase().indexOf("public static void main(string[] args)") != -1);
                } catch (IOException e) {
                    return false;
                }
            })
            .findFirst()
            .map(Path::getFileName)
            .map(Path::toString)
            .orElse(null);
        } catch (IOException e) {
            return null;
        }
    }
}