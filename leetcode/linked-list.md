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

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


class SolutionTest {
    Solution sol;

    @BeforeEach
    void setUp() {
        sol = new Solution();
    }

    @Test
    void testTrueDetectCycle() {
        ListNode list = buildLinkedListWithCycle(List.of(1, 2, 3, 4, 5), 2);
        ListNode expected = buildLinkedListWithCycle(List.of(3, 4, 5), 0);
        equalsLinkedListsWithCycle(expected, sol.detectCycle(list));
    }

    @Test
    void testFalseDetectCycle() {
        ListNode list = buildLinkedListWithCycle(List.of(1, 2, 3, 4, 5), -1);
        equalsLinkedListsWithCycle(null, sol.detectCycle(list));
    }

    private ListNode buildLinkedListWithCycle(List<Integer> lst, int pos){
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode posNode = null;
        for (int i = 0; i < lst.size(); i++) {
            ListNode next = new ListNode();
            next.val = lst.get(i);
            cur.next = next;
            cur = cur.next;
            if (i == pos) {
                posNode = cur;
            }
        }
        cur.next = posNode;
        return head.next;
    }

    private boolean equalsLinkedListsWithCycle(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return true;
        if (list1.val == list2.val && list1 == list1.next && list2 == list2.next) return true;

        ListNode head = list1;
        boolean res = true;
        while (head != list1.next) {
            if (list1.val != list2.val) {
                res = false;
                break;
            } else {
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return res;
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
public ListNode detectCycle(ListNode head) {
    boolean res = false;
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
        if (slowPointer == fastPointer) {
            res = true;
            break;
        }
    }
    
    if (!res) {
        return null;
    } else {
        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
```


## Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/

## Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/