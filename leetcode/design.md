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

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary><blockquote>

``` java 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @org.junit.jupiter.api.Test
    void testMyQueue() {
        MyQueue queue = new MyQueue();
        queue.push(5);
        queue.push(10);
        queue.push(2);
        queue.pop();
        List<Integer> list = Arrays.asList(10, 2);
        ArrayDeque<Integer> ad = new ArrayDeque<>(list);
        Arrays.equals(ad.toArray(), queue.queue.toArray());
    }
}
```

</blockquote></details>


``` java
class MyQueue {
    Deque<Integer> queue;

    public MyQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
```


## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/