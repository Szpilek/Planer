package app.planer.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {
    public static <T, R> List<R> transform(Function<T, R> mapper, Collection<T> c) {
        return c.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
