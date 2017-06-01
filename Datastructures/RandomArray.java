package com.datastructures;

public class RandomArray {
    public static int[] getArray(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = (int) (Math.random() * 100);
        }
        return result;
    }
}
