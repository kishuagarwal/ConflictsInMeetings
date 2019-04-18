package com.kishuagarwal;

/**
 * @author kishu.agarwal
 */
public class AttendeesConflictResolverStrategy implements ConflictResolverStrategy {

    @Override
    public CalendarEntry resolve(CalendarEntry first, CalendarEntry second) {
        if (first.getAttendees() != second.getAttendees()) {
            if (first.getAttendees() < second.getAttendees()) {
                return first;
            } else if (first.getAttendees() > second.getAttendees()) {
                return second;
            }
        }
        return null;
    }
}
