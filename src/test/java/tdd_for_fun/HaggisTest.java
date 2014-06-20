package tdd_for_fun;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HaggisTest {

    public static final double PRIMARY_FORCE = 2.0;
    public static final double MASS = 2.0;
    public static final int DELAY = 3;
    public static final double SECONDARY_FORCE = 1.0;
    public static final int PRIMARY_VEL = 1;

    @Test
    public void shouldReturnTheDistanceTraveled() throws Exception {
        Haggis haggis = new Haggis(PRIMARY_FORCE, MASS, DELAY, SECONDARY_FORCE, PRIMARY_VEL);
        assertThat(haggis.getDistanceTraveled(5), is(13.5D));
    }
}
