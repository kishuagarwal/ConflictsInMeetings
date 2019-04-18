package com.kishuagarwal;

import java.util.Comparator;

/**
 * @author kishu.agarwal
 */
public class CalendarTimeComparator implements Comparator<CalendarEntry> {

    @Override
    public int compare(CalendarEntry first, CalendarEntry second) {
        if (first.getFrom().before(second.getFrom())) {
            return -1;
        } else if (first.getFrom().after(second.getFrom())) {
            return 1;
        } else {
            return 0;
        }
    }
}
