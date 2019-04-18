package com.kishuagarwal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kishu.agarwal
 */
public class ConflictResolver {
    private Calendar calendar;
    private ConflictResolverStrategy resolverStrategy;
    private List<CalendarEntry> resolvedCalendar;

    public ConflictResolver(Calendar calendar, ConflictResolverStrategy resolverStrategy) {
        this.calendar = calendar;
        this.resolverStrategy = resolverStrategy;
        this.resolvedCalendar = new ArrayList<>();
    }

    private boolean isConflicting(CalendarEntry first, CalendarEntry second) {
        int fromCompare = first.getFrom().compareTo(second.getFrom());
        int toCompare = first.getTo().compareTo(second.getFrom());

        return fromCompare <= 0 && toCompare > 0;
    }

    public void resolve() {
        List<CalendarEntry> sortedCalendar = new ArrayList<>(calendar.getMeetings());
        sortedCalendar.sort(new CalendarTimeComparator());

        int lastMeeting = 0;

        for (int i = 1; i < sortedCalendar.size(); i += 1) {
            if (isConflicting(sortedCalendar.get(lastMeeting), sortedCalendar.get(i))) {
                CalendarEntry entry = resolverStrategy.resolve(sortedCalendar.get(i), sortedCalendar.get(lastMeeting));
                if (entry.equals(sortedCalendar.get(lastMeeting))) {
                    resolvedCalendar.add(sortedCalendar.get(lastMeeting));
                } else {
                    lastMeeting = i;
                }
            } else {
                resolvedCalendar.add(sortedCalendar.get(lastMeeting));
                lastMeeting = i;
            }
        }

        resolvedCalendar.add(sortedCalendar.get(lastMeeting));
    }

    public List<CalendarEntry> getResolvedCalendar() {
        return this.resolvedCalendar;
    }
}
