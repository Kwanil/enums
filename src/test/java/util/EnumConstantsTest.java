package util;

import enums.util.EnumConstants;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by naver on 2017. 7. 11..
 */
public class EnumConstantsTest {
    enum Status {
        READY(1),
        BIGIN(2),
        END(3);

        final int id;
        Status(int id){
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    @Test
    public void firstConstant() throws Exception {
        Status constant = EnumConstants.findFirst(Status.class, e -> e.getId() == 1).get();
        assertThat(constant, is(Status.READY));
    }

    @Test(expected = RuntimeException.class)
    public void firstConstant1() throws Exception {
        Status constant = EnumConstants.findFirst(Status.class, e -> e.getId() == 0).orElseThrow(RuntimeException::new);
        assertThat(constant, is(Status.READY));
    }

}