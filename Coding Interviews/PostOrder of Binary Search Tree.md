# 二叉搜索树的后续遍历序列

二叉搜索树的后续遍历序列最后一个节点就是根节点  
左边小于根节点的节点就是左子树的后续遍历序列 
剩下部分就是右子树的后续遍历序列  
不过右边序列中不能出现小于根节点的值  
按照上面步骤递归判断左子树和右子树

Note：这题有个坑就是空树不是二叉搜索树


``` Java
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int leftIndex = 0;
        //找左子树的范围
        while (sequence[leftIndex] < root) {
            leftIndex ++;
        }
        //找右子树的范围
        int rightIndex = leftIndex;
        for(int length = sequence.length - 1; rightIndex < length; rightIndex ++) {
            if (sequence[rightIndex] < root) {
                return false;
            }
        }
        boolean result = true;
        int[] left = Arrays.copyOfRange(sequence, 0, leftIndex);
        if (left.length != 0) {
            result = result && VerifySquenceOfBST(left);
        }
        int[] right = Arrays.copyOfRange(sequence, leftIndex, rightIndex);
        if (right.length != 0) {
            result = result && VerifySquenceOfBST(right);
        }
        return result;
    }
}
```