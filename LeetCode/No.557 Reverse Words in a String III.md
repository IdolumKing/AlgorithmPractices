# Reverse Words in a String III

遍历字符串，用两个指针，i每到一个空格就停下来，和j做交换 

```Java
public class Solution {
    public String reverseWords(String s) {
        char[] word = s.toCharArray();
        int j = 0;
        for (int i = 0, length = word.length; i < length; i++) {
            if (word[i] == ' ') {
                reverse(word, j, i - 1);
                j = i + 1;
            }
        }
        reverse(word, j, word.length - 1);
        return String.valueOf(word);
    }
    public void reverse(char[] word, int i, int j) {
        if (i >= j) {
            return;
        }
        char tmp;
        while (i < j) {
            tmp = word[i];
            word[i] = word[j];
            word[j] = tmp;
            i++;
            j--;
        }
    }
}
```