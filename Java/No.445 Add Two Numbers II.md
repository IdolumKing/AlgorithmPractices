# Add Two Numbers II

``` Java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode c1 = l1, c2 = l2;
        while(c1 != null){
            s1.push(c1.val);
            c1 = c1.next;
        }
        while(c2 != null){
            s2.push(c2.val);
            c2 = c2.next;
        }
        int sum = 0;
        ListNode list = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()){
                sum += s1.pop();
            }
            if(!s2.empty()){
                sum += s2.pop();
            }
            list.val = sum % 10;
            ListNode pre = new ListNode(sum / 10);
            pre.next = list;
            list = pre;
            sum = sum / 10;
        }
        return list.val == 0 ? list.next : list;
    }
}
```