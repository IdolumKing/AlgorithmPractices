# 用两个栈实现队列


把栈2拿来充当缓冲区，每次入队把数据往栈1里压，这样数据的顺序和队列的顺序是相反的。  
等到出队的时候，把栈1的元素挨个弹出压入到栈2中，这样数据的顺序就对了，然后下次出队弹栈2就行了。
注意边界值的判断。

``` Java
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (!stack2.isEmpty()) {
            return stack2.pop();
        }else {
            while (stack1.size() > 1){
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
    }
}
```