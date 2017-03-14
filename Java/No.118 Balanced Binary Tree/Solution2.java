
/**
 * Created by Idolum on 2017/3/14.
 */


public class Solution2 {
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
