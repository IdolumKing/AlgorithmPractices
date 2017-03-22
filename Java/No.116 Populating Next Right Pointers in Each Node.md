# Populating Next Right Pointers in Each Node

思路我是看了答案的，但是我不理解为什么性能在29%,还有0ms的。  
层序遍历：设置一个指针代表树的层，一个指针从这一层的左侧遍历到右侧，并设置子树的next指针。
``` Java
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }
        TreeLinkNode level = root, current = root;
        while (level.left != null){
            current = level;
            while (current != null){
                current.left.next = current.right;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            level = level.left;
        }
    }
}
```