# 栈的压入、弹出序列

通过判断弹出序列，如果弹出的栈是栈顶元素，则直接弹出  
否则从压入序列中一直压入元素，直到压入序列到达末尾，这时候结束

``` Java
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if (pushA == null || popA == null || pushA.length != popA.length) {
          return false;
      	}
        Stack<Integer> buffer = new Stack<>();
        for(int i = 0, j = 0, length = popA.length; i < length;) {
            if(buffer.isEmpty() || buffer.peek() != popA[i]) {
                if (j == length) {
                	return false;
            	}
                buffer.push(pushA[j++]);
            }else {
                buffer.pop();
                i++;
            }
        }
        return true;
    }
}
```