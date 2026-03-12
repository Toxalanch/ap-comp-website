package com.toxalanch.apCompWebsite.runner;

import java.nio.file.Path;

public class Queuer {
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
}