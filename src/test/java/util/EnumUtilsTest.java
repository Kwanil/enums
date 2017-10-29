package util;

import enums.util.EnumUtils;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by naver on 2017. 7. 11..
 */
public class EnumUtilsTest {
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
        Status constant = EnumUtils.firstConstant(Status.class, e -> e.getId() == 1);
        assertThat(constant, is(Status.READY));
    }

    @Test(expected = RuntimeException.class)
    public void firstConstant1() throws Exception {
        Status constant = EnumUtils.firstConstant(Status.class, e -> e.getId() == 0, RuntimeException::new);
        assertThat(constant, is(Status.READY));
    }

}