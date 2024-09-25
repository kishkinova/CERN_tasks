import firstTask.DuplicateElements;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateElementsTest {

    @Test
    public void findDuplicatesUsingStream_withDuplicates() {
        List<String> input = Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d");
        List<String> expected = Arrays.asList("a", "c", "d");
        List<String> actual = DuplicateElements.findDuplicatesUsingStream(input);
        assertEquals(expected, actual);
    }

    @Test
    public void findDuplicatesUsingStream_withNoDuplicates() {
        List<String> input = Arrays.asList("b", "a", "c", "e");
        List<String> expected = List.of();
        List<String> actual = DuplicateElements.findDuplicatesUsingStream(input);
        assertEquals(expected, actual);
    }

    @Test
    public void findDuplicatesUsingStream_withEmptyList() {
        List<String> input = List.of();
        List<String> expected = List.of();
        List<String> actual = DuplicateElements.findDuplicatesUsingStream(input);
        assertEquals(expected, actual);
    }

    @Test
    public void findDuplicatesUsingHashMap_withDuplicates() {
        List<String> input = Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d");
        List<String> expected = Arrays.asList("a", "c", "d");
        List<String> actual = DuplicateElements.findDuplicatesUsingHashMap(input);
        assertEquals(expected, actual);
    }

    @Test
    public void findDuplicatesUsingHashMap_withNoDuplicates() {
        List<String> input = Arrays.asList("b", "a", "c", "e");
        List<String> expected = List.of();
        List<String> actual = DuplicateElements.findDuplicatesUsingHashMap(input);
        assertEquals(expected, actual);
    }

    @Test
    public void findDuplicatesUsingHashMap_withEmptyList() {
        List<String> input = List.of();
        List<String> expected = List.of();
        List<String> actual = DuplicateElements.findDuplicatesUsingHashMap(input);
        assertEquals(expected, actual);
    }
}
