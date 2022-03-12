package com.my.chars;

import org.eclipse.collections.api.bag.primitive.CharBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.factory.Strings;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class TestFiltering {
    @Test
    public void countDistinctLetters() {
        String line = "qwertyuio4jhfs8ssuqnqnqs";
        String expected = "qwertyuiojhfsn";

        String ecDistinctLetters = Strings.asChars(line).select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase).distinct().toString();
        String jdkDistinctLetters = line.chars().filter(Character::isAlphabetic)
                .map(Character::toLowerCase).distinct().mapToObj(Character::toString).collect(Collectors.joining());

        assertEquals(expected, ecDistinctLetters);
        assertEquals(expected, jdkDistinctLetters);
    }

    @Test
    public void topLettersEc() {
        String line = "qwertyuio4jhfs8ssuqnqs";
        ListIterable<CharIntPair> ecExpected =
                CharIntHashMap.newWithKeysValues('s', 4, 'q', 3, 'u', 2)
                        .keyValuesView().toImmutableSortedList((o1, o2) -> o2.getTwo() - o1.getTwo());
        List<Map.Entry<String, Integer>> jdkExpected = Map.of("s", 4, "q", 3, "u", 2)
                .entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toList();

        CharBag charBag = Strings.asChars(line).select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase).toBag();
        ListIterable<CharIntPair> ecFirstFour = charBag.topOccurrences(3);
        Map<String, Long> stringIntMap = line.chars().filter(Character::isAlphabetic)
                .map(Character::toLowerCase).mapToObj(Character::toString)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        List<Map.Entry<String, Integer>> jdkFirstFour = stringIntMap.entrySet().stream()
                .map(entry -> {
                    return Map.entry(entry.getKey(), entry.getValue().intValue());
                })
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).toList();

        assertEquals(ecExpected, ecFirstFour);
        assertEquals(jdkExpected, jdkFirstFour);
    }

    @Test
    public void testFinMostSeenLetter() {
        String line = "qwertyuio4jhfs8ssuqnqs";
        String expected = "s";

        Map<String, Long> stringIntMap = line.chars().filter(Character::isAlphabetic)
                .map(Character::toLowerCase).mapToObj(Character::toString)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        String mostSeenLetter = stringIntMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
        assertEquals(expected, mostSeenLetter);
    }

    @Test
    public void testDuplicateAndUniqueChars() {
        String line = "qwetyu4jfs8ssuqqs";
        MutableCharSet expectedDuplicates = new CharHashSet('q', 's', 'u');
        MutableCharSet expectedUnique = new CharHashSet('f', 'j', 'y', 't', 'w', 'e');

        MutableCharBag charBag = Strings.asChars(line).select(Character::isAlphabetic)
                .collectChar(Character::toLowerCase).toBag();
        MutableCharSet duplicates = charBag.selectDuplicates().toSet();
        MutableCharSet unique = charBag.selectUnique();

        assertEquals(expectedDuplicates, duplicates);
        assertEquals(expectedUnique, unique);
    }
}
