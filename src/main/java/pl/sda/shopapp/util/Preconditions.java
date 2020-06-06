package pl.sda.shopapp.util;

import java.util.Objects;

public class Preconditions {

    public static void requireNonNulls(Object ...args) {
        for (Object arg : args) {
            Objects.requireNonNull(arg);
        }
    }
}
