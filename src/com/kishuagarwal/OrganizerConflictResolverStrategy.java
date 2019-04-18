package com.kishuagarwal;

/**
 * @author kishu.agarwal
 */
public class OrganizerConflictResolverStrategy implements ConflictResolverStrategy {
    private Employee employee;

    public OrganizerConflictResolverStrategy(Employee employee) {
        this.employee = employee;
    }

    @Override
    public CalendarEntry resolve(CalendarEntry first, CalendarEntry second) {
        if (first.getOrganizer().equals(this.employee)) {
            return first;
        } else if (second.getOrganizer().equals(this.employee)) {
            return second;
        } else {
            return null;
        }
    }
}
