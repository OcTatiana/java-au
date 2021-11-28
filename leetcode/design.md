# Design

+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)
+ [LRU Cache](#lru-cache)
+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)
+ [Binary Search Tree Iterator](#binary-search-tree-iterator)


## Flatten Nested List Iterator

https://leetcode.com/problems/flatten-nested-list-iterator/

## LRU Cache

https://leetcode.com/problems/lru-cache/

## Min Stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary><blockquote>

``` java 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @org.junit.jupiter.api.Test
    void testMinStack() {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(10);
        stack.push(-2);
        stack.pop();
        List<Integer> list = Arrays.asList(10, 5);
        ArrayDeque<Integer> ad = new ArrayDeque<>(list);
        Arrays.equals(ad.toArray(), stack.stack.toArray());
    }

    @org.junit.jupiter.api.Test
    void testGetMin() {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(0);
        stack.push(2);
        assertEquals(0, stack.getMin());
    }
}
```

</blockquote></details>


``` java
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```


## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/