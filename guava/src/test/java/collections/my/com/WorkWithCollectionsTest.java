package collections.my.com;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class WorkWithCollectionsTest {
    @Test
    public void givenList_whenParitioningToSubLists_thenCorrect() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subLists = Lists.partition(intList, 3);

        List<Integer> lastPartition = Lists.newArrayList(7, 8);
        assertThat(subLists.size(), equalTo(3));
        assertThat(lastPartition, equalTo(subLists.get(2)));
    }

    @Test
    public void givenPartitionedList_whenOriginalListIsModified_thenPartitionsChange() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subLists = Lists.partition(intList, 3);
        intList.add(9);

        List<Integer> lastPartition = Lists.newArrayList(7, 8, 9);
        assertThat(lastPartition, equalTo(subLists.get(2)));
    }

    @Test
    public void givenList_whenParitioningIntoSublistsUsingPartitionBy_thenCorrect() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> groups = intList.stream().collect(Collectors.partitioningBy(i -> i > 6));
        List<List<Integer>> subList = groups.values().stream().toList();

        List<Integer> lastPartition = subList.get(1);
        List<Integer> expectedLastPartition = Arrays.asList(7, 8);
        assertThat(subList.size(), equalTo(2));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    @Test
    public void givenList_whenSortByPredicat_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        List<String> result = names.stream().filter(Predicates.containsPattern("a")::apply).toList();

        assertTrue(result.containsAll(List.of("Jane", "Adam")));
    }

    @Test
    public void givenList_withCustomPredicateFilter_thenCorrect() {
        Predicate<String> predicate = s -> s.startsWith("A") && s.endsWith("p");
        List<String> names = Lists.newArrayList("Aohn", "Aane", "Adap", "Top");
        List<String> result = names.stream().filter(predicate::apply).toList();

        assertEquals(result, List.of("Adap"));
    }

    @Test
    public void givenList_withMultiplePredicateFilter_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<String> result = Collections2.filter(names,
                Predicates.or(Predicates.containsPattern("J"),
                        Predicates.not(Predicates.containsPattern("a"))));

        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of("John", "Jane", "Tom")));
    }

    @Test
    public void whenCheckingIfAllElementsMatchACondition_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        boolean result = names.stream().allMatch(Predicates.containsPattern("n|m")::apply);
        assertTrue(result);

        result = names.stream().allMatch(Predicates.containsPattern("a")::apply);
        assertFalse(result);
    }

    @Test
    public void whenTransformWithIterables_thenTransformed() {
        Function<String, Integer> function = input -> {
            assert input != null;
            return input.length();
        };

        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        List<Integer> result = names.stream().map(function).toList();

        assertEquals(result, List.of(4, 4, 4, 3));
    }

    @Test
    public void whenCreatingAFunctionFromAPredicate_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Boolean> result =
                Collections2.transform(names,
                        Functions.forPredicate(Predicates.containsPattern("m")));

        assertEquals(4, result.size());
        assertEquals(result, List.of(false, false, true, true));
    }

    @Test
    public void whenFilteringAndTransformingCollection_thenCorrect() {
        Predicate<String> predicate = input -> {
            assert input != null;
            return input.startsWith("A") || input.startsWith("T");
        };

        Function<String, Integer> func = input -> {
            return input.length();
        };

        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Integer> result = names.stream().filter(predicate).map(func)
                .toList();

        assertEquals(2, result.size());
        assertEquals(result, List.of(4, 3));
    }
}
