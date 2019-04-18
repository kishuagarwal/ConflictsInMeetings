package com.kishuagarwal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kishu.agarwal
 */
public class MultiConflictResolverStrategy implements ConflictResolverStrategy {
    private List<ConflictResolverStrategy> resolverStrategies = new ArrayList<>();

    public void add(ConflictResolverStrategy resolverStrategy) {
        resolverStrategies.add(resolverStrategy);
    }

    @Override
    public CalendarEntry resolve(CalendarEntry first, CalendarEntry second) {
        for (ConflictResolverStrategy resolverStrategy: resolverStrategies) {
            CalendarEntry entry = resolverStrategy.resolve(first, second);
            if (entry != null) {
                return entry;
            }
        }
        return null;
    }
}
