# 数组中只出现一次的数

蛮常见的题目，因为一个数与自己本身异或结果是0   
所以把数组中所有元素异或，得到的结果就是两个要得到的值的异或结果  
从整个结果中找出为1的一位，这个1表示两个num中必有一个num的这个位是1，一个是0  
按照这个结果把数组的元素分成两组，一组是这个位是1,一组不是，重新对两组元素异或旧得到了两个num  


``` Java
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
        for(int i = 0; i < array.length; i++){
            result ^= array[i];
        }
        int flag = 0;
        while(result != 0){
            
            flag++;
            result = result >> 1;
            if((result & 1) == 1){
                break;
            }
        }
        int n1 = 0, n2 = 0;
        for(int i = 0; i < array.length; i++){
            if(((array[i] >> flag) & 1) == 1){
                n1 ^= array[i];
            }else{
                n2 ^= array[i];
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }
}
```