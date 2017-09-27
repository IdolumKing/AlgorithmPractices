# Invert Binary Tree

现在Leetcode越来越有意思了，下面有个Trivia说Homebrew因为不会写翻转二叉树被谷歌拒了的故事

> Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

这题就是通过递归的翻转节点的最优子树来做，当然，也可以用栈来保存中间节点，用循环做

```Java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```