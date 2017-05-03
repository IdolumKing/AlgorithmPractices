# 平衡二叉树

这题之前在LeetCode上做过了，再重做一遍.
``` Java
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
```