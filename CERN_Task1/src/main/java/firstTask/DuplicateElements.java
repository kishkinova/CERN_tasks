package firstTask;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A class for finding duplicate elements in a list.
 * I decided to provide two methods for finding duplicates:
 * the first one using Java Streams and another one manually using a Hash Map.
 * There are tests for both functions in the test directory.
 */

public class DuplicateElements {

    public static List<String> findDuplicatesUsingStream(List<String> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findDuplicatesUsingHashMap(List<String> elements) {
        Map<String, Integer> frequency = new LinkedHashMap<>();
        List<String> duplicates = new ArrayList<>();

        for (String element : elements) {
            int count = frequency.getOrDefault(element, 0);
            frequency.put(element, count + 1);
        }
        for (String element : frequency.keySet()) {
            if (frequency.get(element) > 1) {
                duplicates.add(element);
            }
        }
        return duplicates;
    }
}
