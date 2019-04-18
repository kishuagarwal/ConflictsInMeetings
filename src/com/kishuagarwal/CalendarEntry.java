package com.kishuagarwal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kishu.agarwal
 */

public class CalendarEntry {
    private String meetingName;
    private Date from;
    private Date to;
    private Employee organizer;
    private int attendees;

    public CalendarEntry(String meetingName, Date from, Date to, Employee organizer, int attendees) {
        this.meetingName = meetingName;
        this.from = from;
        this.to = to;
        this.organizer = organizer;
        this.attendees = attendees;
    }

    public CalendarEntry(String meetingName, String from, String to, Employee organizer, int attendees) {
        this.meetingName = meetingName;
        try {
            this.from = new SimpleDateFormat("hh:mma").parse(from);
            this.to = new SimpleDateFormat("hh:mma").parse(to);
        } catch (ParseException e) {
            System.err.println("Error parsing " + e.getMessage());
        }
        this.organizer = organizer;
        this.attendees = attendees;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Employee getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Employee organizer) {
        this.organizer = organizer;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarEntry)) {
            return false;
        }
        CalendarEntry other = (CalendarEntry) obj;
        return this.meetingName.equals(other.meetingName)
                && this.from.equals(other.from)
                && this.to.equals(other.to)
                && this.organizer.equals(other.organizer);
    }

    @Override
    public String toString() {
        return "CalendarEntry{" +
                "meetingName='" + meetingName + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", organizer=" + organizer +
                ", attendees=" + attendees +
                '}';
    }
}
