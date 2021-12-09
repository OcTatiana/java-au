# Stream

+ [Get Words By Length](#get-words-by-length)
+ [Get Reverse Words](#get-reverse-words)
+ [Get Sorted Distance](#get-sorted-distance)
+ [Get Top 10](#get-top-10)
+ [Get Authors With Posts](#get-authors-with-posts)
+ [Top K Frequent Words](#top-k-frequent-words)


## Get Words By Length


## Get Reverse Words


## Get Sorted Distance


## Get Top 10


## Get Authors With Posts


## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testTopKFrequent() {
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> expected = List.of("the", "is", "sunny", "day");
        assertEquals(expected, sol.topKFrequent(words, 4));
    }
}
```

</blockquote></details>


``` java
public List<String> topKFrequent(String[] words, int k) {
    return Stream.of(words)
            .sorted()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(k)
            .map(pair -> pair.getKey())
            .collect(Collectors.toList());
    }
```