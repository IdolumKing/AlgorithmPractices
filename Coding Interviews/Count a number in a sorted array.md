# 数组在排序数组中出现的次数

通过二分法找出数字在数组中的起始位置，二分法找出数字在数组中的终点位置。
Note: 注意边界值

``` Java
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        int start = getStartIndex(array, k);
        int end = getEndIndex(array, k);
        if (start != -1 && end != -1){
            return end - start + 1;
        }
        return 0;
    }
    public int getStartIndex(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (array[mid] >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end != 0 &&array[end - 1] == k) {
            return end - 1;
        } else if (array[end] == k) {
            return end;
        } else {
            return -1;
        }
    }
    public int getEndIndex(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (array[mid] <= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start != array.length - 1 && array[start + 1] == k) {
            return start + 1;
        } else if (array[start] == k){
            return start;
        } else {
            return -1;
        }
    }
}
```