# Linked List

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the linked list](#middle-of-the-linked-list)

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

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
    void testReverseNullHead() {
        ListNode node = null;
        assertEquals(null, sol.reverseList(node));
    }

    @org.junit.jupiter.api.Test
    void testReverseList() {
        ListNode node = null;
        ListNode expected = buildLinkedList(List.of(1, 2, 3, 4, 5));
        assertEquals(expected, sol.reverseList(buildLinkedList(List.of(5, 4, 3, 2, 1))));
    }

    @org.junit.jupiter.api.Test
    void testPrintList() {
        ListNode expected = buildLinkedList(List.of(1, 2, 3, 4, 5));
        System.out.println(expected);
    }

    private ListNode buildLinkedList(List<Integer> sourse) {
        ListNode node = null;
        ListNode prev = null;
        for (int i = sourse.size() - 1; i >= 0; i--) {
            node = new ListNode(sourse.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
       int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return  val + "->" + next;
    }

```

</blockquote></details>




``` java
public ListNode reverseList(ListNode head) {
    ListNode next = null;
    ListNode cur = head;
    ListNode prev = null;

    while (cur != null) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void testMiddleNodeInOddList() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = buildLinkedList(List.of(3, 4, 5));
        assertEquals(expected, sol.middleNode(list));
    }

    @Test
    void testMiddleNodeInEvenList() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4));
        ListNode expected = buildLinkedList(List.of(3, 4));
        assertEquals(expected, sol.middleNode(list));
    }

    private ListNode buildLinkedList(List<Integer> source) {
        ListNode node = null;
        ListNode prev = null;
        for (int i = source.size() - 1; i >= 0; i--) {
            node = new ListNode(source.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
       int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
```

</blockquote></details>




``` java
public ListNode middleNode(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }

    return slowPointer;
}
```