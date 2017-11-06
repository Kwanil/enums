package enums.interfaces;

import java.util.Objects;

import static enums.util.EnumConstants.findFirst;

/**
 * Created by Rabin on 2017-07-11.
 */
@FunctionalInterface
public interface EnumValue {

    String getValue();

    static <T extends Enum<T> & EnumValue> T of(Class<T> enumClazz, String value) {
        return findFirst(enumClazz,
                c -> Objects.equals(c.getValue(), value))
                .orElseThrow(()->new IllegalArgumentException("Not found enum constant. argument : " + value));
    }
}
