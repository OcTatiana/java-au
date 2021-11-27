# Array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)


## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SolutionTest {
    @Test
    void testSortedSquares1() {
        int[] nums = new int[]{1, 2, 3, 6};
        int[] expected = new int[]{1, 4, 9, 36};
        Arrays.equals(nums, expected);
    }

    @Test
    void testSortedSquares2() {
        int[] nums = new int[]{-2, -1, 3, 6};
        int[] expected = new int[]{1, 4, 9, 36};
        Arrays.equals(nums, expected);
    }
}
```

</blockquote></details>


``` java
public int[] sortedSquares(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] * nums[i];
    }
    Arrays.sort(nums);
    return nums;
}
```