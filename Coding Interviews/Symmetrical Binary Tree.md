# 对称的二叉树

1. 可以顺着题目来，直接求出树的镜像，然后递归对比子节点

2. 也可以直接判断左子树的右子树和右子树的左节点是否相同

   ```java
   public class Solution {
       boolean isSymmetrical(TreeNode pRoot){
           if (pRoot == null) {
               return true;
           }
           return isSymmetrical(pRoot.left, pRoot.right);

       }
       boolean isSymmetrical(TreeNode left, TreeNode right){
           if (left == null && right == null) {
               return true;
           }
           if (left == null || right == null) {
               return false;
           }
           return left.val == right.val && isSymmetrical(left.right, right.left)
                   && isSymmetrical(left.left, right.right);

       }
   }
   ```