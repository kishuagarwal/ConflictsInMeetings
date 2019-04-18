package com.kishuagarwal;

/**
 * @author kishu.agarwal
 */
public interface ConflictResolverStrategy {

    /**
     * Given two conflicting meetings, choose one
     * @param first
     * @param second
     */
    CalendarEntry resolve(CalendarEntry first, CalendarEntry second);
}
