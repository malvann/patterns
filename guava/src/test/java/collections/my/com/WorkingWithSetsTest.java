package collections.my.com;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WorkingWithSetsTest {
    @Test
    public void testUnion() {
        Set<Character> s1 = ImmutableSet.of('a', 'b', 'd');
        Set<Character> s2 = ImmutableSet.of('b', 'c', 'd');

        Sets.SetView<Character> res = Sets.union(s1, s2);
        Set<Character> expected = Sets.newHashSet('a', 'b', 'd', 'c');

        assertEquals(expected, res);
    }

    @Test
    public void testJoin() {
        Set<Character> first = ImmutableSet.of('a', 'b');
        Set<Character> second = ImmutableSet.of('c', 'd');
        Set<List<Character>> result = Sets.cartesianProduct(ImmutableList.of(first, second));

        List<String> collect = result.stream().map(input -> Joiner.on(" ").join(input)).toList();
        HashSet<String> expected = Sets.newHashSet("a c", "a d", "b c", "b d");

        assertTrue(collect.containsAll(expected));
    }

    @Test
    public void testIntersection() {
        Set<Character> first = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second = ImmutableSet.of('b', 'c', 'd');

        Set<Character> actual = Sets.intersection(first, second);
        Set<Character> expected = Sets.newHashSet('b', 'c');

        assertEquals(expected, actual);
    }

    @Test
    public void testSymmetricDifference() {
        Set<Character> first = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second = ImmutableSet.of('b', 'c', 'd');

        Set<Character> actual = Sets.symmetricDifference(first, second);
        Set<Character> expected = Set.of('a', 'd');

        assertEquals(expected, actual);
    }
}
