# Stream

+ [Get Words By Length](#get-words-by-length)
+ [Get Reverse Words](#get-reverse-words)
+ [Get Sorted Distance](#get-sorted-distance)
+ [Get Top 10](#get-top-10)
+ [Get Authors With Posts](#get-authors-with-posts)
+ [Top K Frequent Words](#top-k-frequent-words)


## Get Words By Length

A string is given, and you have to find all the words (substrings separated by a space) which are greater than the given length 5.

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
    void testGetWordsByLength() {
        String input = "one twoooo three fourrrr";
        List<String> expected = List.of("twoooo", "fourrrr");
        assertEquals(expected, sol.getWordsByLength(input));
    }
}
```

</blockquote></details>


``` java
public List<String> getWordsByLength(String sentence) {
    return Stream.of(sentence.split(" "))
            .filter(word -> word.length() > 5)
            .collect(Collectors.toList());
}
```


## Get Reverse Words

A string is given, and you have to reverse all words.

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;
    
    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testGetReverseWords() {
        String input = "1 two three";
        String expected = "1 owt eerht";
        assertEquals(expected, sol.getReverseWords(input));
    }
}
```

</blockquote></details>


``` java
public String getReverseWords(String sentence) {
    return Stream.of(sentence.split(" "))
            .map(word -> new StringBuilder(word).reverse())
            .collect(Collectors.joining(" "));
}
```


## Get Sorted Distance

Given two arrays with x and y coordinates of points, the task is to sort points in II and IV quadrants according to their distance from the point (0,0).

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testGetDistanceSorted() {
        List<Integer> xCoords = List.of(1, -2, -1, 1);
        List<Integer> yCoords = List.of(1, 3, -1, -1);
        List<Map.Entry<Integer, Integer>> expected = List.of(Map.entry(1,-1), Map.entry(-2, 3));
        assertEquals(expected, sol.getDistanceSorted(xCoords, yCoords));
    }
}
```

</blockquote></details>


``` java
public List<Map.Entry<Integer, Integer>> getDistanceSorted(List<Integer> x, List<Integer> y) {
    return IntStream.range(0, Math.min(x.size(), y.size()))
            .mapToObj(i -> Map.entry(x.get(i), y.get(i)))
            .filter(pair -> pair.getKey() <= 0 && pair.getValue() >= 0 || pair.getKey() >= 0 && pair.getValue() <= 0)
            .sorted((o1, o2)-> {
                Integer dist1 = o1.getKey() * o1.getKey() + o1.getValue() * o1.getValue();
                Integer dist2 = o2.getKey() * o2.getKey() + o2.getValue() * o2.getValue();
                return dist1.compareTo(dist2);
            })
            .collect(Collectors.toList());
    }
```


## Get Top 10

Return Top 10 posts in a feed.

<details><summary>Test Cases</summary><blockquote>

Test:
``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testGetDistanceSorted() {
        List<Post> feed = createFeed(11);
        List<Comment> comments = List.of(new Comment());
        List<Post> expected = List.of(
                new Post(11, comments),
                new Post(10, comments),
                new Post(9, comments),
                new Post(8, comments),
                new Post(7, comments),
                new Post(6, comments),
                new Post(5, comments),
                new Post(4, comments),
                new Post(3, comments),
                new Post(2, comments)
                );
        System.out.println(feed);
        assertEquals(expected, sol.getTop10(feed));
    }

    List<Post> createFeed(int length) {
        List<Post> feed = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            List<Comment> comments = List.of(new Comment());
            Post post = new Post(length - i, comments);
            feed.add(post);
        }

        return feed;
    }
}
```

Post:
``` java
import java.util.List;
import java.util.Objects;

public class Post {
    private int id;
    private int likes;
    private String text;
    private long authorId;
    private List<Comment> comments;

    Post (int likes, List<Comment> comments) {
        this.likes = likes;
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && getLikes() == post.getLikes() && authorId == post.authorId && Objects.equals(text, post.text) && Objects.equals(getComments(), post.getComments());
    }
}
```

Comment:
``` java
import java.util.Objects;

public class Comment {
    private int id;
    private String text;
    private long authorId;

    Comment() {}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && authorId == comment.authorId && Objects.equals(text, comment.text);
    }
}
```

</blockquote></details>


``` java
public List<Post> getTop10(List<Post> feed) {
    return feed.stream()
            .sorted((o1, o2) -> {
                Integer rank1 = o1.getLikes() + o1.getComments().size();
                Integer rank2 = o2.getLikes() + o2.getComments().size();
                return rank2.compareTo(rank1);
            })
            .limit(10)
            .collect(Collectors.toList());
}
```


## Get Authors With Posts


## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/