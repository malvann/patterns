package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSolutions {
    public static void matchingANumberOnlyIfNotPrecededByASpecificWord() {
        String text = "cats 100, dogs 200";
        Pattern pattern = Pattern.compile("(?<!dogs )\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number not preceded by dogs: " + matcher.group());
        }
    }

    public static void matchingANumberOnlyIfPrecededByASpecificWord() {
        String text = "cats 100, dogs 200";
        Pattern pattern = Pattern.compile("(?<=cats )\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number preceded by cats: " + matcher.group());
        }
    }

    public static void matchingANumberOnlyIfNotFollowedByASpecificWord() {
        String text = "100 cats, 200 dogs";
        Pattern pattern = Pattern.compile("\\d+(?! cats)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number not followed by cats: " + matcher.group());
        }
    }

    public static void matchingANumberOnlyIfFollowedByASpecificWord() {
        String text = "100 cats, 200 dogs";
        Pattern pattern = Pattern.compile("\\d+(?= cats)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number followed by cats: " + matcher.group());
        }
    }

    public static void quantifiersAndGreedyBehavior() {
        String text = "<tag>content</tag>";
        // Greedy
        Pattern patternGreedy = Pattern.compile("<.*>");
        // Non-Greedy
        Pattern patternNonGreedy = Pattern.compile("<.*?>");

        System.out.println(" -> " + text.replaceAll("<.*?>", ""));

        Matcher matcherGreedy = patternGreedy.matcher(text);
        if (matcherGreedy.find()) {
            System.out.println("Greedy Match: " + matcherGreedy.group());
        }

        Matcher matcherNonGreedy = patternNonGreedy.matcher(text);
        if (matcherNonGreedy.find()) {
            System.out.println("Non-Greedy Match: " + matcherNonGreedy.group());
        }
    }

    public static void negativeLookbehind() {
        String text = "cats 5, dogs 10";
        Pattern pattern = Pattern.compile("(?<!cats )\\b\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number found: " + matcher.group());
        }
    }

    public static void positiveLookahead() {
        String text = "5 cats, 10 dogs";
        Pattern pattern = Pattern.compile("\\d+(?= cats)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Number of cats: " + matcher.group());
        }
    }

    public static void findingDuplicates() {
        String text = "word word";
        Pattern pattern = Pattern.compile("(\\b\\w+\\b) \\1");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Duplicate word found: " + matcher.group(1));
        }
    }

    public static void groupingWithoutCapturing() {
        String text = "He said yes. She said no.";
        Pattern pattern = Pattern.compile("(?:He|She) said (yes|no)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Response: " + matcher.group(1));
        }
    }

    public static void capturingGroups() {
        String text = "John: 123456, Jane: 987654";
        Pattern pattern = Pattern.compile("(\\w+): (\\d+)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Name: " + matcher.group(1));
            System.out.println("Number: " + matcher.group(2));
        }
    }

    public static void findingMultipleOccurrences() {
        String dates = "2020-04-28, 2021-05-30, 2023-04-12";
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(dates);

        while (matcher.find()) {
            System.out.println("Date found: " + matcher.group());
        }
    }
}
