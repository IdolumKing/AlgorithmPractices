# 复杂链表的复制
链表中每个节点都指向了后面的一个随机节点  
常规思路是访问一个节点，遍历整个链表就可以知道那个随机节点的位置  
这样时间复杂度是O(n^2)  
其实可以为新链表和旧链表搭建个关系，因为旧链表每个节点和随机节点都对应一个关系  
通过新旧关系以及旧节点与随机节点就可以知道新链表的随机节点的位置  
所以整个过程分三步:
1. 新旧建立联系，这里把新链表的每个节点插在旧链表后面
2. 遍历链表，给新链表的每个节点构造随机节点
3. 遍历链表，把新旧拆分出来

``` Java
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode newP = newHead;
        while(p != null){
            RandomListNode pnext = new RandomListNode(p.label);
            pnext.next = p.next;
            p.next = pnext;
            p = pnext.next;
        }
        p = pHead;
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = pHead;
        while(p != null){
            newP.next = p.next;
            p.next = p.next.next;
            p = p.next;
            newP = newP.next;
        }
        return newHead.next;
    }
}
```