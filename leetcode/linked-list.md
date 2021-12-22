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

## Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/

## Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/

## Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    void testRemove1st() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = buildLinkedList(List.of(2, 3, 4, 5));
        assertEquals(expected, sol.removeNthFromEnd(list, 5));
    }

    @Test
    void testRemoveNthFromEnd() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = buildLinkedList(List.of(1, 2, 4, 5));
        assertEquals(expected, sol.removeNthFromEnd(list, 3));
    }

    @Test
    void testRemove1stFromEnd() {
        ListNode list = buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = buildLinkedList(List.of(1, 2, 3, 4));
        assertEquals(expected, sol.removeNthFromEnd(list, 1));
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
public ListNode removeNthFromEnd(ListNode head, int n) {
    int lenList = getLengthOfTheList(head);
    ListNode cur = head;

    if (lenList == n) {
        return head.next;
    }

    int l = lenList - n - 1;
    while (l > 0) {
        cur = cur.next;
        l = l - 1;
    }
    if (cur.next != null) {
        cur.next = cur.next.next;
    }

    return head;
}

private int getLengthOfTheList(ListNode head) {
    ListNode cur = head;
    int lenList = 0;

    while (cur != null) {
        lenList += 1;
        cur = cur.next;
    }

    return lenList;
}
```