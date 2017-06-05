# 第一个只出现一次的字符
用一个哈希表来记录字符出现的个数  
第一次遍历字符串统计个数，第二次找字符串中第一个出现的  
如果只能遍历字符串一次，可以再用一个哈希表来记录字符出现顺序  
```Java
public class Solution {
   public int FirstNotRepeatingChar(String str) {
        int[] count = new int[256];
        for (int i = 0, length = str.length(); i < length; i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0, length = str.length(); i < length; i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```