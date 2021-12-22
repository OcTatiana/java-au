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
    void testGetIntersectionNode1() {
        ListNode expected = buildLinkedList(List.of(3, 5), null);
        ListNode headA = buildLinkedList(List.of(1, 2), expected);
        ListNode headB = buildLinkedList(List.of(5, 3, 5), expected);
        assertEquals(expected, sol.getIntersectionNode(headA, headB));
    }

    @Test
    void testGetIntersectionNode2() {
        ListNode expected = buildLinkedList(List.of(8), null);
        ListNode headA = buildLinkedList(List.of(1, 2), expected);
        ListNode headB = buildLinkedList(List.of(5, 3, 5), expected);
        assertEquals(expected, sol.getIntersectionNode(headA, headB));
    }

    private ListNode buildLinkedList(List<Integer> source, ListNode tail) {
        ListNode node = null;
        ListNode prev = tail;
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
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode A = headA;
    ListNode B = headB;
    int lenA = getLength(A);
    int lenB = getLength(B);

    if (lenA < lenB) {
        while (lenA != lenB) {
            headB = headB.next;
            lenB -= 1;
        }
    }

    if (lenB < lenA) {
        while (lenA != lenB) {
            headA = headA.next;
            lenA -= 1;
        }
    }

    while (headA != null || headB != null) {
        if (headA == headB) {
            return headA;
        } else {
            headA = headA.next;
            headB = headB.next;
        }
    }
    return null;
}

private int getLength (ListNode list) {
    int lenList = 0;

    while (list != null) {
        lenList += 1;
        list = list.next;
    }
    return lenList;
}
```


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