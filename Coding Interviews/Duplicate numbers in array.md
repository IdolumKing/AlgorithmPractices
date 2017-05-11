# 数组中重复的数字

可以用哈希表记录数组中重复的元素，空间为n  
不过这题限制了数字的范围, (0,n-1)  
所以我们可以把数组本身拿来做哈希表  
以数组元素的值作为索引，索引到的数组值取负  
如果是重复的元素，就会索引到同一个数组值两次

```Java
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || length == 0) {
            return false;
        }
        for(int i = 0; i < length; i++) {
            int index = Math.abs(numbers[i]);
            if (numbers[index] >= 0) {
                numbers[index] = -1 * numbers[index];
            } else {
                duplication[0] = index;
                return true;
            }
        }
        return false;
    }
}
```