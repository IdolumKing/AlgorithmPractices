# 包含min函数的栈

这题容易有的一个误区就是直接在类里面设置一个Min变量，这样当Min变量被Pop的时候，  
第二小的值就没有了。所以选择设置一个辅助栈，大小和主栈一样。如果后push的值比Min当前的大  
就Push 辅助栈顶端值。

Note: Java Stack类的top方法是peek() 原先我以为是peak

``` Java
import java.util.Stack;

public class Solution {
	
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty() && minStack.peek() < node){
            minStack.push(minStack.peek());
        }else{
            minStack.push(node);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        	minStack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()){
            return stack.pop();
        }
        return 0;
    }
    
    public int min() {
        if (!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;
    }
}
```