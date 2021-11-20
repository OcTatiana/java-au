# Tree

+ [Binary Search Tree Iterator](#binary-search-tree-iterator)

## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {
    @org.junit.jupiter.api.Test
    void testTreeWithFiveElements() {
        BSTIterator tree = new BSTIterator(createTree1());
        assertTrue(tree.hasNext());
        assertEquals(1, tree.next());
        tree.next();
        tree.next();
        tree.next();
        tree.next();
        assertFalse(tree.hasNext());
    }

    @org.junit.jupiter.api.Test
    void testTreeWithFourElements() {
        BSTIterator tree = new BSTIterator(createTree2());
        assertTrue(tree.hasNext());
        assertEquals(2, tree.next());
        tree.next();
        tree.next();
        tree.next();
        assertFalse(tree.hasNext());
    }

    @org.junit.jupiter.api.Test
    void testTreeWithThreeElements() {
        BSTIterator tree = new BSTIterator(createTree3());
        assertTrue(tree.hasNext());
        assertEquals(1, tree.next());
        tree.next();
        tree.next();
        assertFalse(tree.hasNext());
    }

    private TreeNode createTree1()
    {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode root = new TreeNode(2, first, second);

        return root;
    }

    private TreeNode createTree2()
    {
        TreeNode second = new TreeNode(5);
        TreeNode first = new TreeNode(2, null, new TreeNode(4));
        TreeNode root = new TreeNode(4, first, second);

        return root;
    }

    private TreeNode createTree3()
    {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
        return root;
    }
}
```

``` java
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
```

</blockquote></details>




``` java
public class BSTIterator {
    Deque<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        fill(root);
    }

    public int next() {
        TreeNode cur = nodes.pop();
        fill(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    private void fill(TreeNode root) {
        while (root != null) {
            nodes.push(root);
            root = root.left;
        }
    }
}
```

