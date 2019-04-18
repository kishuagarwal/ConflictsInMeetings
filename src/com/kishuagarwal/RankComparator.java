package com.kishuagarwal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author kishu.agarwal
 */
public class RankComparator implements Comparator<Employee> {
    private static final List<String> ranks = new ArrayList<>(Arrays.asList("CEO", "COO", "DIRECTOR", "MANAGER"));

    @Override
    public int compare(Employee first, Employee second) {
        return ranks.indexOf(first.getRank()) - ranks.indexOf(second.getRank());
    }
}
