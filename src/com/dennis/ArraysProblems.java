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
}
