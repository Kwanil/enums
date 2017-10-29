package interfaces;

import enums.interfaces.EnumCode;
import enums.interfaces.EnumValue;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rabin on 2017-07-11.
 */
public class EnumValueTest {
    enum ValueStatus implements EnumCode, EnumValue {
        READY("R","Ready"), COMPLETE("C", "Complete"), NOTHING("N","None");
        final String code;
        final String value;

        private ValueStatus(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getCode(){
            return code;
        }
        public String getValue() {
            return value;
        }
    }

    @Test
    public void valueOf() throws Exception {
        ValueStatus complate = EnumValue.of(ValueStatus.class, "Ready");
        assertThat(complate, is(ValueStatus.READY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfFail() throws Exception {
        ValueStatus complate = EnumValue.of(ValueStatus.class, "A");
        assertThat(complate, is(ValueStatus.READY));
    }

}
