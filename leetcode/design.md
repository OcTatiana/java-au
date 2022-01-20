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

## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary><blockquote>

``` java 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @org.junit.jupiter.api.Test
    void testMyStack() {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(10);
        stack.push(-2);
        stack.pop();
        List<Integer> list = Arrays.asList(10, 5);
        ArrayDeque<Integer> ad = new ArrayDeque<>(list);
        Arrays.equals(ad.toArray(), stack.stack.toArray());
    }

    @org.junit.jupiter.api.Test
    void testTopOfMyStack() {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(10);
        stack.push(-2);
        assertEquals(-2, stack.top());
    }
}
```

</blockquote></details>


``` java
class MyStack {
    Deque<Integer> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
```


## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/