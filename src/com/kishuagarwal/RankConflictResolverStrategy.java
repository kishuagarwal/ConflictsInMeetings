package com.kishuagarwal;

/**
 * @author kishu.agarwal
 */
public class RankConflictResolverStrategy implements ConflictResolverStrategy {
    private static final RankComparator rankComparator = new RankComparator();

    @Override
    public CalendarEntry resolve(CalendarEntry first, CalendarEntry second) {
        int compareValue = rankComparator.compare(first.getOrganizer(), second.getOrganizer());
        if (compareValue < 0) {
            return first;
        } else if (compareValue > 0) {
            return second;
        } else {
            return null;
        }
    }
}
