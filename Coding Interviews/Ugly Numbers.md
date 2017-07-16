# 丑数
这题和算素数的方法差不多，用类似素数筛子的方法，空间换时间  
构建一个数组，后面的数组元素是前面的数组元素的两倍，三倍，五倍的最小值  
注意最小值要满足大于前一个元素的值
```Java
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int ugly2Index = 0, ugly3Index = 0, ugly5Index = 0;
        int min = 1;
        for (int i = 1; i < index; i++) {
            while (uglyNumbers[ugly2Index] * 2 <= min) {
                ugly2Index++;
            }
            while (uglyNumbers[ugly3Index] * 3 <= min) {
                ugly3Index++;
            }
            while (uglyNumbers[ugly5Index] * 5 <= min) {
                ugly5Index++;
            }
            uglyNumbers[i] = getMinOfThree(uglyNumbers[ugly2Index] * 2,
                    uglyNumbers[ugly3Index] * 3, uglyNumbers[ugly5Index] * 5);
            min = uglyNumbers[i];
        }
        return uglyNumbers[index - 1];
    }
    private int getMinOfThree(int u1, int u2, int u3) {
        int min = u1 < u2 ? u1 : u2;
        return min < u3 ? min : u3;
    }
}
```