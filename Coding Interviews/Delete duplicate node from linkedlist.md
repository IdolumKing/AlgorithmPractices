# 删除链表中重复的节点

一开始我以为只是删除重复的那部分节点，没想到是重复节点的所有都删掉，一个不留  
这种删除题一般都要设置个哨兵指针，省得处理太多边界值  
我的思路是设置一个pre,发现指针p有重复的部分就一直遍历，然后pre.next = p.next;  

```Java
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //设置哨兵节点
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode p = pHead, pre = newHead;
        while(p!= null && p.next != null) {
            //遍历重复的节点
            while (p.next != null && p.next.val == p.val) {
                p = p.next;
            }
            //判断前一个指针和当前指针，不是前驱的关系证明说出现过重复的节点
            if (pre.next != p) {
                pre.next = p.next;
            } else {
                pre = pre.next;
            }
            p = p.next;
        }
        return newHead.next;
    }
}
```