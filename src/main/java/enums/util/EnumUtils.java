package enums.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Rabin on 2017-07-11.
 */
public final class EnumUtils {
    private EnumUtils(){
    }

    public static <E extends Enum<E>> E firstConstant(Class<E> enumClass, Predicate<E> predicate) {
        return firstConstant(enumClass, predicate, ()->new IllegalArgumentException("Not found constant."));
    }

    public static <E extends Enum<E>, X extends Exception> E firstConstant(Class<E> enumClass, Predicate<E> predicate, Supplier<? extends X> notFoundException) throws X {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(notFoundException);
        E[] enumConstants = Objects.requireNonNull(enumClass).getEnumConstants();
        Optional<E> optional = Arrays.stream(enumConstants).filter(predicate).findFirst();
        return optional.orElseThrow(notFoundException);
    }
}
