package com.dennis;

import java.util.*;

public class ArraysProblems
{

    public int[][] mergeImprov(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for(int[] p : intervals){
            int len  = merged.size() -1;
            if(merged.isEmpty()){
                merged.add(p);
            }else if(merged.get(len)[1] < p[0]){
                merged.add(p);
            }else{
                merged.get(len)[1] = Math.max(merged.get(len)[1], p[1]);
            }


        }

        return  merged.toArray(new int[merged.size()][]);
    }

    //insert interval
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>inserted = new ArrayList<>();
        for(int[] p: intervals){
            int len = inserted.size() -1;
            if(inserted.isEmpty()){
                inserted.add(p);
            }else if(inserted.get(len)[1] > newInterval[0]){
                inserted.get(len)[1] = Math.max(inserted.get(len)[1], newInterval[1]);
            }else{
                inserted.add(p);
            }
        }
        return inserted.toArray(new int[inserted.size()][]);

    }

    //search a 2d matrix implements binary search
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i = matrix.length-1; i >= 0; i--){
            if(target > matrix[i][0]){
                int right = matrix[i].length -1;
                int left = 0;
                while (left <= right){
                    int mid = left +(right - left)/2;
                    if(target == matrix[i][mid]) return true;
                    else{
                        if(target < matrix[i][mid]){
                            right = mid - 1;
                        }else{
                            left = mid + 1;
                        }
                    }
                }
                return false;
            }else if(target == matrix[i][0]) return true;
        }
        return false;
    }

    public boolean searchMatrix2(int[][]matrix, int target){
        int p = matrix.length -1;
        while(p >= 0){
            int left = 0;
            int right = matrix[p].length -1;
            while(left <= right){
                int mid = left +(right - left)/2;
                if(target == matrix[p][mid]) return true;
                else{
                    if(target < matrix[p][mid]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }
            p--;
        }
        return false;
    }
}
