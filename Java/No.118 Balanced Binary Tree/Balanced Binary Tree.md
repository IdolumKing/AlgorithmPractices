# Balanced Binary Tree


这题我记得在剑指offer上也看到过，书上说如果直接递归左右子树是否平衡会重复遍历子节点。  


引用LeetCode上的两种方法:

-**自顶向下**的方法: 复杂度为O(N^2)


``` Java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
```

-**自下而上**的方法: 复杂度为O(N)

利用深度优先遍历的思想，计算子树的高度，判断子树是不是平衡树

是就返回树的高度，否则就返回-1

``` Java
public class Solution {

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        if (leftDepth == -1){
            return -1;
        }
        int rightDepth = depth(root.right);
        if (rightDepth == -1){
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return depth(root) != -1;
    }
}
```
