# 左旋字符串

把要左移的部分翻转，把剩下的部分翻转，然后翻转整个字符串就是左移了  
这个方法还可以用来求 "I am a student." => "student. a am I"  

```Java
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || n <= 0 || str.length() == 0) {
            return str;
        }
        //如果n超过字符串长度，则左移超出的部分字符
        n = n % str.length();
        char[] word = str.toCharArray();
        reversal(word, 0, n - 1);
        reversal(word, n, str.length() - 1);
        reversal(word, 0, str.length() - 1);
        return String.valueOf(word);
    }
    private void reversal(char[] word, int start, int end) {
        char c;
        while (start < end) {
            c = word[start];
            word[start++] = word[end];
            word[end--] = c;
        }
    }
}
```