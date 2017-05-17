# Count and Say

说实话，一开始没看懂题意，这题表述有点问题  
事实上，就是第n个序列的值是由第n-1个序列读出来的结果    
1. "1"
2. "11"
3. "1211"
4. "111221"
5. “312211”

一开始是1, 读音是11，这是第二个序列  
第二个序列读音是21，这是第三个序列

```Java
public class Solution {
    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }
    public String say(String text) {
        StringBuilder sb = new StringBuilder();
        char[] word = text.toCharArray();
        char last = word[0];
        int count = 1;
        for (int i = 1, length = word.length; i < length; i++) {
            if (word[i] == last) {
                count++;
            } else {
                sb.append(count);
                sb.append(last);
                last = word[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(last);
        return sb.toString();
    }
}
```