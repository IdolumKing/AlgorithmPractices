# 数组中出现次数超过一半的数字
这题好几种解法。
1. 可以排序后取数组中间的数进行比较
2. 用哈希表来记录次数
3. 即我用的方法，用Min来记录最小值，count记录次数，具体如下:  

因为超过数组一般的数比数组中其他任意的数的总和都要多  
遍历数组，min记录最小值，每遇到相同的数count+1,否则count-1  
当count = 0的时候，设Min为下一个数，一直到最后min就是比其他数要多的数  
最后再判断Min是否是数组中超过一般的数
```Java
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0], count = 1;
        for (int i = 1, length = array.length; i < length; i++) {
            if (count == 0) {
                min = array[i];
                count = 1;
            } else if (array[i] == min) {
                count++;
            } else {
                count--;
            }
        }
        if (MoreThanHalf(array, min)) {
            return min;
        }
        return 0;
    }
    public boolean MoreThanHalf(int[] arr, int key) {
        int count = 0;
        for (int i : arr) {
            if (key == i) {
                count++;
            }
        }
        return count > arr.length / 2;
    }
}
```