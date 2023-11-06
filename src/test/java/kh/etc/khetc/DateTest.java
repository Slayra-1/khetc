package kh.etc.khetc;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author khko
 **/
@SpringBootTest
public class DateTest {

    @Test
    public void dateTest() {
        DateTime now = new DateTime();
        int hour = now.getHourOfDay();
        now = now.withTime(6, 0, 0, 0);

        System.out.println(hour);

        System.out.println(now.toDate());
        System.out.println(now.minusDays(1).toDate());
    }
}
