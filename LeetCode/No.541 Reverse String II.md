# Reverse String II

维护一个窗口，窗口的大小是K或者是nk(n = 1, 3 ...)到s.length的长度(也就是不够长)  
在窗口内交换元素  
```Java
public class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int window = 0; window < c.length; window += 2 * k){
            for (int i = window, j = Math.min(window + k - 1, c.length - 1);
                    i < j; i++, j--){
                swap(c, i, j);
            }
        }
        return String.valueOf(c);
    }
    public void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
```