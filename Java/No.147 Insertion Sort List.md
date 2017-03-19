# Insertion Sort List

链表中很多插入题都在头节点之前new了一个节点，这样让在头节点之前插入节点的操作变简单了。   
这题也一样，链表插入排序和数组差不多，遍历链表将节点逐个插入到newHead之后就行了。  
``` Java
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode current = head, pre = newHead, next = null;
        while (current != null){
            next = current.next;
            while (pre.next != null && pre.next.val < current.val){
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            pre = newHead;
            current = next;
        }
        return newHead.next;
    }
}
```
