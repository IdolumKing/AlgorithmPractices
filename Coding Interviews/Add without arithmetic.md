# 不用加减乘除完成加法

直接用位运算来完成加法，一个加法有如下步骤：  
1. 只做各位相加不进位 
2. 做进位
3. 把前面两个结果相加  

这里我的代码是用递归的，用迭代的也不难写。

```Java
public class Solution {
    public int Add(int num1,int num2) {
        //求进位
        int flag = num1 & num2;
        //没进位的和
        int sum = num1 ^ num2;
        if (flag == 0) {
            return sum;
        }
        return Add(flag << 1, sum);
    }
}
```