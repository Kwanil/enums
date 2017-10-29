package interfaces;

import enums.interfaces.EnumValues;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rabin on 2017-07-11.
 */
public class EnumValuesTest {
    enum ValuesStatus implements EnumValues {
        READY("R","준비"), COMPLETE("C", "완료"), NOTHING("N","없음");
        final String[] values;

        private ValuesStatus(String... values) {
            this.values = values;
        }

        public String[] getValues() {
            return values;
        }
    }

    @Test
    public void valueOf() throws Exception {
        ValuesStatus complate1 = EnumValues.of(ValuesStatus.class, "준비");
        assertThat(complate1, is(ValuesStatus.READY));

        ValuesStatus complate = EnumValues.of(ValuesStatus.class, "N");
        assertThat(complate, is(ValuesStatus.NOTHING));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfFail() throws Exception {
        ValuesStatus complate = EnumValues.of(ValuesStatus.class, "A");
        assertThat(complate, is(ValuesStatus.READY));
    }
}
