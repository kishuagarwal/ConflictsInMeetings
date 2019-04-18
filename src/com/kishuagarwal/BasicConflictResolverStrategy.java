package com.kishuagarwal;

/**
 * @author kishu.agarwal
 */
public class BasicConflictResolverStrategy implements ConflictResolverStrategy {
    private Employee employee;
    private RankComparator rankComparator = new RankComparator();

    public BasicConflictResolverStrategy(Employee employee) {
        this.employee = employee;
    }

    @Override
    public CalendarEntry resolve(CalendarEntry first, CalendarEntry second) {
        if (!first.getOrganizer().equals(second.getOrganizer())) {
            // Him/her self as the organizer
            if (first.getOrganizer().equals(employee)) {
                return first;
            } else if (second.getOrganizer().equals(employee)) {
                return second;
            }

            // Rank
            if (rankComparator.compare(first.getOrganizer(), second.getOrganizer()) < 0) {
                return first;
            } else if (rankComparator.compare(first.getOrganizer(), second.getOrganizer()) > 0) {
                return second;
            }
        }

        // Attendees
        if (first.getAttendees() < second.getAttendees()) {
            return first;
        } else if (first.getAttendees() > second.getAttendees()) {
            return second;
        }

        return null;
    }
}
