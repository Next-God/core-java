package com.wan.lambda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * stream test
 */
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(word, (unused) -> new TreeSet<>()).add(word);
            }
        }

        List<String> collected = Stream.of("ab", "ss", "x3")
                                       .map(string -> string.toUpperCase())
                                       .collect(toList());
    }
}
