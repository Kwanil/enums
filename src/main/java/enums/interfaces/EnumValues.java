package enums.interfaces;

import java.util.Arrays;

import static enums.util.EnumUtils.firstConstant;

/**
 * Created by Rabin on 2017-07-11.
 */
@FunctionalInterface
public interface EnumValues {
    String[] getValues();

    static <T extends Enum<T> & EnumValues> T of(Class<T> enumClazz, String value) {
        return firstConstant(enumClazz,
                c -> Arrays.binarySearch(c.getValues(), value) >= 0)
                .orElseThrow(()->new IllegalArgumentException("Not found enum constant. argument : " + value));
    }
}
