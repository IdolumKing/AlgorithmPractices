# Student Attendance Record I

这题可以遍历字符串字符，记录A字符出现的次数或者是LLL连续出现的字符字数  
最近在学正则表达式，所以我用正则表达式来做  

```
public class Solution {
    public boolean checkRecord(String s) {
        String pattern = ".*A.*A.*|.*LLL.*";
        return !s.matches(pattern);
    }
}
```