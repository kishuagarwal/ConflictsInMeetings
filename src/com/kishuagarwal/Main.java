package com.kishuagarwal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee amit = new Employee();
        amit.setName("Amit");
        amit.setRank("DIRECTOR");

        Employee nitish = new Employee();
        nitish.setName("NITISH");
        nitish.setRank("MANAGER");

        Employee kanhaiya = new Employee();
        kanhaiya.setName("KANHAIYA");
        kanhaiya.setRank("COO");

        Employee iravati = new Employee();
        iravati.setName("Iravati");
        iravati.setRank("MANAGER");

        Employee john = new Employee();
        john.setName("John");
        john.setRank("DIRECTOR");


        Calendar amitCalendar = new Calendar();
        List<CalendarEntry> entrires = new ArrayList<>();
        entrires.add(new CalendarEntry("Scrum", "10:15AM", "12:00PM", nitish, 7));
        entrires.add(new CalendarEntry("OKR", "03:00PM", "05:00PM", kanhaiya, 4));
        entrires.add(new CalendarEntry("Design Review", "05:00PM", "06:00PM", iravati, 6));
        entrires.add(new CalendarEntry("Design Discussion", "11:45AM", "01:30PM", amit, 6));
        entrires.add(new CalendarEntry("Team Meeting", "05:30PM", "06:00PM", john, 4));

        amitCalendar.setMeetings(entrires);
        amitCalendar.setPerson(amit);

        amit.setCalendar(amitCalendar);

        MultiConflictResolverStrategy resolverStrategy = new MultiConflictResolverStrategy();
        resolverStrategy.add(new OrganizerConflictResolverStrategy(amit));
        resolverStrategy.add(new RankConflictResolverStrategy());
        resolverStrategy.add(new AttendeesConflictResolverStrategy());

        ConflictResolver conflictResolver = new ConflictResolver(amitCalendar, resolverStrategy);
        conflictResolver.resolve();
        List<CalendarEntry> resolvedEntries = conflictResolver.getResolvedCalendar();

        System.out.println("Resolved calendar");
        System.out.println(resolvedEntries);
    }
}
