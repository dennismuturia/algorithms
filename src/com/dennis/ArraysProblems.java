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

    //This will not work if using O(1) but uses O(N) N = nums space
    public void rotate(int[] nums, int k) {
        int position = 0;
        int[] newArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            position = i  + k;
            while(position > nums.length -1){
                position = position - nums.length;
            }
            newArr[position] = temp;
            if(i == nums.length -1) nums = newArr;
        }
    }

    public String longestCommonPrefix(String[] strs) {
    int k = 0;
    int j = 0;
    String res = "";
    char p = 'a';
    int count = 0;
    int maxCount = 0;
    StringBuilder b = new StringBuilder();
    while(k < strs.length){
        while(j < strs[k].length()){
            if(k == 0){
                b.append(strs[k].charAt(j));
                p = strs[k].charAt(j);
                k+=1;
                break;
            }
            if(p!=strs[k].charAt(j) && b.length() != 0){
                b.delete(b.toString().length() -1,b.toString().length());

                if(count > maxCount){
                    maxCount = count;
                    res = b.toString();
                }
                b.delete(0, b.length());
                count = 0;
                break;
            }else{

                k+=1;
                if(k == strs.length){
                    j+=1;
                    k = 0;
                    count+=1;
                }
            }
        }
        if(k == 0){
            if(b.length() > res.length()){
                res = b.toString();
            }
        }
        if(j >= strs[k].length()){
            break;
        }

    }
    return res;
}



   public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
             prev = current;
             current = next;
        }
        return prev;
   }


    public static long carParkingRoof(List<Long> cars, int k) {
        Collections.sort(cars);
        long diff = 0L;
        long min = cars.get(cars.size() -1);
        int count = 1;
        int i = 0;
        int j = 1;
        while(j < cars.size() && i <=j){
            count+=1;
            if(count == k){
                diff = (cars.get(j) - cars.get(i)) + 1L;
                if(diff < min){
                    min = diff;
                }
                i++;
                j = i;
                count = 1;
            }
            j++;
        }
        return min;
    }


    //flatland space stations
    public static int flatlandSpaceStations(int n, int[] c) {
        int max = 0;
        int count = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(i == c[j]){
                count = 0;
                j+=1;
            }else{
                count+=1;
                if(count > max){
                    max = count;
                }
            }
        }

        return Math.max(count, max) > 0 ? (Math.max(count, max) + 1)/2 : 0;
    }

}
