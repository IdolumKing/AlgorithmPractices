# 矩形覆盖

2*n大小的矩形可以由2*(n-1)大小的矩形加一块 和 2*(n-2)的矩形加两块组成。  
后者的两块只能竖着放，横着放就和2(n-1)重复了。  
所以本质上也是一种斐波那契数列。

``` Java
public class Solution {
    public int RectCover(int target) {
		if (target < 1){
            return 0;
        }
        if(target < 3){
            return target;
        }
        int num1 = 1, num2 = 2, result = 0;
        for (int i = 2; i < target; i++){
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }
}
```