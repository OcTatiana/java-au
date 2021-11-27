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
    void testSortNullList() {
        assertEquals(null, sol.sortList(null));
    }

    @Test
    void testSortList() {
        ListNode list = buildLinkedList(List.of(4, 2, 3, 1));
        ListNode expected = buildLinkedList(List.of(1, 2, 3, 4));
        assertEquals(expected, sol.sortList(list));
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
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode tmp = null;
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    
    while (fastPointer != null && fastPointer.next != null){
        tmp = slowPointer;
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }
    tmp.next = null;
    return mergeTwoLists(sortList(head), sortList(slowPointer));
}

private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode list3 = new ListNode();
    ListNode head = list3;
    
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            list3.next = list1;
            list1 = list1.next;
        }
        else {
            list3.next = list2;
            list2 = list2.next;
        }
        list3 = list3.next;
    }
    
    if (list1 == null) {
        list3.next = list2;
    }
    if (list2 == null) {
        list3.next = list1;
    }

    return head.next;
}
```


## Reorder List

https://leetcode.com/problems/reorder-list/

## Linked List Cycle II

https://leetcode.com/problems/linked-list-cycle-ii/

## Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/

## Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/