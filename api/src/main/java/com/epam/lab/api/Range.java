package com.epam.lab.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range {
    private long lowerBound;
    private long upperBound;

    public Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException();
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isBefore(Range otherRange) {
        return getUpperBound() < otherRange.getLowerBound();
    }

    public boolean isAfter(Range otherRange) {
        return getLowerBound() > otherRange.getUpperBound();
    }

    public boolean isConcurrent(Range otherRange) {
        return (getLowerBound() == otherRange.getLowerBound()) && (getUpperBound() == otherRange.getUpperBound());
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() {
        return upperBound;
    }

    public boolean contains(long value) {
        return value >= getLowerBound() && value <= getUpperBound();
    }

    public List<Long> asList() {
        List<Long> list = new ArrayList<Long>();

        long upperBound = getUpperBound();
        for (long i = getLowerBound(); i <= upperBound; i++) {
            list.add(i);
        }

        return list;
    }

    public Iterator<Long> asIterator() {
        return new Iterator<Long>() {
            long current = getLowerBound();
            long upperBound = getUpperBound();

            public boolean hasNext() {
                return current < upperBound;
            }

            public Long next() {
                Long result = current;

                current++;

                return result;
            }
        };
    }
}