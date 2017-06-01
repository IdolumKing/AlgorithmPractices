package com.datastructures;

public class Sort {
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int tmp = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot){
                high--;
            }
            if (low < high){
                arr[low++] = arr[high];
            }
            while (low < high && arr[low] <= pivot){
                low++;
            }
            if (low <high){
                arr[high--] = arr[low];
            }
        }
        arr[low] = pivot;
        return low;
    }
}
