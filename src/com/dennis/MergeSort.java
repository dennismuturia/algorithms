package com.dennis;

public class MergeSort {
    public int[] sort(int [] arr, int n){
        if(n < 2){
            return arr;
        }
        int midpoint  = n/2;
        int[] left = new int[midpoint];
        int[] right = new int[n  - midpoint];

        for(int i = 0; i < midpoint; i++){
            left[i] = arr[i];
        }

        for (int i = midpoint; i < arr.length ; i++) {
            right[i -midpoint] = arr[i];
        }

        sort(left, midpoint);
        sort(right, n - midpoint);
        merge2(left, right, arr, midpoint, n - midpoint);
        return arr;
    }


    void merge2(int[] left, int[] right, int []arr, int leftp, int rightp){
        int i = 0, j = 0, k = 0;
        while(i < leftp && j < rightp){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i < leftp){
            arr[k++] = left[i++];
        }
        while (j < rightp){
            arr[k++] = right[j++];
        }
    }
}
