package interfaces;

import enums.interfaces.EnumCode;
import enums.interfaces.EnumValue;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Rabin on 2017-07-11.
 */
public class EnumCodeTest {
    enum CodeStatus implements EnumCode, EnumValue {
        READY("R","Ready"), COMPLETE("C", "Complete"), NOTHING("N","None");
        final String code;
        final String value;

        private CodeStatus(String code, String value) {
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
    public void codeOf() throws Exception {
        CodeStatus complate = EnumCode.of(CodeStatus.class, "R");
        assertThat(complate, is(CodeStatus.READY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void codeOfFail() throws Exception {
        CodeStatus complate = EnumCode.of(CodeStatus.class, "A");
        assertThat(complate, is(CodeStatus.READY));
    }

}