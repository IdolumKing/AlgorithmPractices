# 把数组排成最小的数
排序数组，把小的数字放前面，然后遍历数组，组合成一个字符串，就是最小的数  
小的数字不是字面的意思，例如3是比32大的，3和32组合，332和323，后者比较小，所以32比3小  
这里我们用的规则为: ab < ba，则a < b  
然后构造一个比较器Comparator，来比较数组
```Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    
    class IntegerComparator implements Comparator<Integer> {

    	@Override
    	public int compare(Integer o1, Integer o2) {
        	int l12 = Integer.parseInt(o1.toString() + o2.toString());
        	int l21 = Integer.parseInt(o2.toString() + o1.toString());
        	return l12 - l21;
    	}
	}
    
    public String PrintMinNumber(int[] numbers) {
        Integer[] n = new Integer[numbers.length];
        for (int i = 0, length = numbers.length; i < length; i++) {
            n[i] = numbers[i];
        }
        Arrays.sort(n, new IntegerComparator());
        StringBuilder sb = new StringBuilder();
        for (int i : n) {
            sb.append(i);
        }
        return sb.toString();
    }
    
}
```