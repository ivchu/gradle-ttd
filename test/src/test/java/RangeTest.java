import com.epam.lab.api.Range;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class RangeTest {
    @Test
    public void testIsBefore() {
        Range r1 = new Range(10, 15);
        Range r2 = new Range(2, 5);

        assertThat(r2.isBefore(r1), is(true));
        assertThat(r1.isBefore(r2), is(false));
    }

    @Test
    public void testIsAfter() {
        Range r1 = new Range(10, 15);
        Range r2 = new Range(2, 5);

        assertThat(r1.isAfter(r2), is(true));
        assertThat(r2.isAfter(r1), is(false));
    }

    @Test
    public void testIsConcurrent() {
        Range r1 = new Range(10, 15);
        Range r2 = new Range(10, 15);
        Range r3 = new Range(2, 5);

        assertThat(r1.isConcurrent(r2), is(true));
        assertThat(r2.isConcurrent(r3), is(false));
    }

    @Test
    public void testGetBounds() {
        Range r1 = new Range(10, 15);

        assertThat(r1.getLowerBound(), is(10L));
        assertThat(r1.getUpperBound(), is(15L));
    }

    @Test
    public void testContains() {
        Range r1 = new Range(10, 15);

        assertThat(r1.contains(10L), is(true));
        assertThat(r1.contains(15L), is(true));
        assertThat(r1.contains(12L), is(true));
        assertThat(r1.contains(20L), is(false));
        assertThat(r1.contains(3L), is(false));
    }

    @Test
    public void testAsList() {
        Range r1 = new Range(10, 15);
        List<Long> list = r1.asList();

        assertThat(list.size(), is(6));
        assertThat(list.get(0), is(10L));
        assertThat(list.get(5), is(15L));
    }

    @Test
    public void testAsIterator() {
        Range r1 = new Range(10, 12);

        Iterator<Long> iterator = r1.asIterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(10L));
        assertThat(iterator.next(), is(11L));
        assertThat(iterator.next(), is(12L));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatConstructorThrowsExceptionOnWrongArguments() {
        new Range(10, 5);
    }
}