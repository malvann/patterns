package collections.my.com;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class WorkWithCollections {
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
}
