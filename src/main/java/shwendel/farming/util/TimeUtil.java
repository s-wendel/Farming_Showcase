package shwendel.farming.util;

public class TimeUtil {

    // 50 millis = 1 tick, double so we get double division and not integer division,
    // If you divide 1 / 2 and 1 and 2 are both integers, it won't yield 0.5 in Java; if 1 or 2 is a double, it will return 0.5
    // look up Java integer vs double division for more info
    private static final double MILLIS_PER_TICK = 50;

    public static long millisToTicks(long millis) {
        return (long) Math.ceil(millis / MILLIS_PER_TICK);
    }

}
