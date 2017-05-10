# 两个链表的公共节点

思路是先统计两个链表的长度，然后让长的链表先走一段距离直到两个链表同样大小  
之后挨个比较每个节点，一样的话就是共同节点
代码看起来比较复杂，不过我觉得看起来还算清晰吧，这样写。

```Java
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0, length2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        //遍历两个链表， 计算长度
        while (p1 != null) {
            length1 ++;
            p1 = p1.next;
        }
        while (p2 != null) {
            length2 ++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        //遍历长的链表直到两个链表对齐
        if (length1 > length2) {
            int diff = length1 - length2;
            while (diff > 0) {
                diff --;
                p1 = p1.next;
            }
        } else {
            int diff = length2 - length1;
            while (diff > 0) {
                diff --;
                p2 = p2.next;
            }
        }
        //对比两个链表的元素
        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
```