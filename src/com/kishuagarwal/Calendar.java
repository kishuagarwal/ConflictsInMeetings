package com.kishuagarwal;

import java.util.List;

/**
 * @author kishu.agarwal
 */
public class Calendar {
    Employee person;
    List<CalendarEntry> meetings;

    public Employee getPerson() {
        return person;
    }

    public void setPerson(Employee person) {
        this.person = person;
    }

    public List<CalendarEntry> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<CalendarEntry> meetings) {
        this.meetings = meetings;
    }
}
