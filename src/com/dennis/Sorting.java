package com.dennis;

public class Sorting {
    //Merge sort
    public int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        int midpoint = arr.length/2;

        int[] left = new int[midpoint];
        int[] right;
        if(arr.length %2 == 0){
            right = new int[midpoint];
        }else {
            right = new int[midpoint+1];
        }


        for (int i = 0; i < midpoint; i++){
            left[i] = arr[i];
        }
        for(int j = 0;j < right.length; j++){
            right[j] = arr[midpoint + j];
        }

        int[] res;
        left = mergeSort(left);
        right = mergeSort(right);

        res = merge(left, right);
        return res;
    }

    private int[] merge(int[] left,int[] right){
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;
        int[] res = new int[left.length + right.length];

        while(leftPointer < left.length || rightPointer < right.length){
            if(leftPointer < left.length && rightPointer < right.length){
                if(left[leftPointer] < right[rightPointer]){
                    res[resultPointer++] = left[leftPointer++];
                }else{
                    res[resultPointer++] = right[rightPointer++];
                }
            }else if(leftPointer < left.length){
                res[resultPointer++] = left[leftPointer++];
            }else if(rightPointer < right.length){
                res[resultPointer++] = right[rightPointer++];
            }
        }
        return res;
    }
}
