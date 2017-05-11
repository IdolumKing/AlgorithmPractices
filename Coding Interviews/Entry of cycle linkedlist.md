# 链表中环的入口节点

设置两个指针，一个一次走两步，一个一次走一步 
遍历链表，如果两个链表相交即有环  
找链表环的入口，可以让快指针返回头节点，然后两个指针相同速度往后走  
两个指针相遇的地方就是链表环的入口（可以自己画图理解）

```Java
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        //设置快慢指针，相交即为有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //让快指针从头开始，慢指针从相交节点开始，一直到两个节点再相交
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```