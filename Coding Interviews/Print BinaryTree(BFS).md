# 从上往下打印二叉树

这题就是树的宽度优先搜索，用队列实现。



``` Java
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> treeList = new LinkedList<>();
        if (root != null){
            treeList.add(root);
        }
        while(!treeList.isEmpty()){
            TreeNode tmp = (TreeNode)treeList.getFirst();
            result.add(tmp.val);
            if (tmp.left != null){
                treeList.add(tmp.left);
            }
            if (tmp.right != null){
                treeList.add(tmp.right);
            }
            treeList.removeFirst();
        }
        return result;
    }
}
```