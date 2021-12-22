# Linked List

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)
+ [Reorder List](#reorder-list)
+ [Linked List Cycle II](#linked-list-cycle-ii)
+ [Linked List Cycle](#linked-list-cycle)
+ [Remove Nth Node From End of List](#remove-nth-node-from-end-of-list)


## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

## Sort List

https://leetcode.com/problems/sort-list/

## Reorder List

https://leetcode.com/problems/reorder-list/

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
    void testMiddle() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected_right = buildLinkedList(List.of(4, 5));
        ListNode expected_left = buildLinkedList(List.of(1, 2, 3));
        assertEquals(expected_right, sol.middleNode(list));
        assertEquals(expected_left, list);
    }

    @Test
    void testMerge() {
        ListNode expected = buildLinkedList(List.of(1, 4, 2, 5, 3));
        ListNode list1 = buildLinkedList(List.of(1, 2, 3));
        ListNode list2 = buildLinkedList(List.of(4, 5));
        assertEquals(expected, sol.mergeTwoLists(list1, list2));
    }
    
    @Test
    void testReorderList() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = buildLinkedList(List.of(1, 5, 2, 4, 3));
        sol.reorderList(list);
        assertEquals(expected, list);
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
}
```

</blockquote></details>


``` java
public void reorderList(ListNode head) {
    ListNode prev_middle = middleNode(head);
    ListNode list1 = head;
    ListNode list2 = reverseList(prev_middle);
    mergeTwoLists(list1, list2);
}

private ListNode reverseList(ListNode head) {
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

public ListNode middleNode(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    ListNode prevSlowPointer = null;
        
    while (fastPointer != null && fastPointer.next != null) {
        prevSlowPointer = slowPointer;
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }

    if (fastPointer == null) {
        prevSlowPointer.next = null;
        return slowPointer;
    } else {
        ListNode res = slowPointer.next;
        slowPointer.next = null;
        return res;
    }
}

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode cur1 = list1;
    ListNode cur2 = list2;
    ListNode next1;
    ListNode next2;

    while (cur1 != null && cur2 != null) {
        next1 = cur1.next;
        next2 = cur2.next;
        cur1.next = cur2;
        cur2.next = next1;
        cur1 = next1;
        cur2 = next2;
    }
    return list1;
}
```


## Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/

## Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/

## Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/