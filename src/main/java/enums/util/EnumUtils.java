package enums.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by Rabin on 2017-07-11.
 */
public final class EnumUtils {
    private EnumUtils(){
    }

    public static <E extends Enum<E>> Optional<E> firstConstant(Class<E> enumClass, Predicate<E> predicate) {
        Objects.requireNonNull(predicate);
        E[] enumConstants = Objects.requireNonNull(enumClass).getEnumConstants();
        return Arrays.stream(enumConstants).filter(predicate).findFirst();
    }

}
