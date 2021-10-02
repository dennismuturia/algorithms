package com.dennis;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }

    static int minJumps(int[] vals){
        int current = 0;
        int count = 0;
        int max= 0;
        int left  = vals.length - 1;
        for (int i = 0;i < vals.length ;i++) {
            if(i == 0) {
                current = vals[i]; //start of the jump
                max = current;
            }
            if(vals[i] > max){
                max = vals[i];
            }

            if(current <= 0){
                current = vals[i];
                count+=1;
            }
            if(vals[i] >= max){
                if(current == 0) return current;
                count+=1;
                current = vals[i] +1;
            }
            if(left - current <=1){
                return count;
            }
            current -=1;
            left -= 1;
        }
        return count;
    }

    static char firstNotRepeatingCharacter(String s) {
        List<Character>items = new ArrayList<>();
        Set<Character>itemm = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!items.contains(s.charAt(i))){
                items.add(s.charAt(i));
            }else{
                itemm.add(s.charAt(i));
            }
        }
        for(Character i: items){
            if(!itemm.contains(i)){
                return i;
            }
        }
        return '-';

    }

    static boolean almostIncreasingSequence(int[] sequence) {
        int count = 0;
        List<Integer>res = new ArrayList<>();

        for(int i = 1; i < sequence.length ; i++){
            if(i == 1){
                res.add(sequence[i -1]);
            }
            int p = sequence[i -1];
            if(sequence[i]< p || res.contains(sequence[i])){
                count+=1;
            }else{
                res.add(sequence[i]);
            }

        }
        if(count > 1) return false;
        return true;
    }


    static int commonCharacterCount(String s1, String s2) {
        List<Character> char1= s1.chars().mapToObj(x -> (char)x).sorted().collect(Collectors.toList());
        List<Character> char2= s2.chars().mapToObj(y -> (char)y).sorted().collect(Collectors.toList());

        int count = 0;
        int i = 0;
        int j = i;
        for(i = 0; i < char1.size(); i++){
            if(char1.get(i) == char2.get(j)){
                count+=1;
            }else{

            }
        }

        return count;
    }

    static int lateRide(int n) {
        int hours = 0;
        int minutes = 0;
        while(n > 0){
            if(n%60 == 0){
                n = n-60;
                hours+=1;
            }else{
                n = n-1;
                minutes +=1;
            }
        }

        if(minutes >0){
            return hours +1;
        }else{
            return hours;
        }
    }
    public static int solution(String[] T, String[] R) {
        //get the groups first
        Map<String, String>myMap = new HashMap<>();
        for(int i = 0; i < T.length; i++){
            String val  = T[i].replaceAll("[^\\d.]", "");
            if(!myMap.containsKey(val)){
                myMap.put(val, R[i]);
            }
        }

        int count = 0;
        for (String key:myMap.keySet()) {
            if(myMap.get(key).equals("OK")){
                count+=1;
            }
        }

        return (count * 100)/ myMap.size();
    }

    public static int solution1(int[] A, int S) {
        int count = 0;
        int count1 = 0;
        int i = 0;
        int j = 1;
        int sum = 0;
        while(count < A.length){
            if(i == 0 && count == 0){
                while(i < A.length){
                    if(A[i] == S){
                        count1++;
                    }
                    i+=1;
                }
            }else{
                for (int k = 0; k <=count; k++) {
                    sum+=A[k];
                }
                if(sum%(count + 1) == 0){
                    count1+=1;
                }
            }
            
            count+=1;
        }
        return count1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};

        int midpoint = nums.length/2;
        while(midpoint < nums.length && midpoint >= 0){
            if(midpoint == 0 && nums[midpoint] != target || midpoint == nums.length -1 && nums[midpoint] != target){
                if(midpoint -1 >= 0){
                    if(nums[midpoint -1] == target){
                        res[0] = midpoint -1;
                        res[1] = midpoint -1;
                    }

                }
                break;
            }
            //start at the mid point
            if(nums[midpoint] == target){
                if(midpoint != nums.length -1){
                    if(nums[midpoint + 1] == target){
                        res[0] = midpoint;
                        res[1] = midpoint+1;
                        break;
                    }
                    else{
                        res[0] = midpoint;
                        res[1] = midpoint;
                        break;
                    }
                }if(midpoint != 0){
                    if(nums[midpoint - 1] == target){
                        res[0] =midpoint;
                        res[1] = midpoint-1;
                        break;
                    }else{
                        res[0] = midpoint;
                        res[1] = midpoint;
                        break;
                    }
                }else{
                    if(nums[midpoint] == target){
                        res[0] = midpoint;
                        res[1] = midpoint;
                        break;
                    }
                }
            }else if(target < nums[midpoint]){
                midpoint = midpoint/2;
            }else if(target > nums[midpoint]){
                midpoint =midpoint+ ((nums.length - midpoint)/2);
            }

        }
        Arrays.sort(res);
        return res;
    }
   static List<Integer>rotate(List<Integer>a, int p ){
        while(p > 0){
            int temp = a.get(0);
            for (int i = 0; i < a.size()-1; i++) {
                a.set(i, a.get(i+1));
            }
            a.set(a.size() - 1, temp);
            p-=1;
        }
        return a;
   }
   //iteretive
    static int binarySearch1(int[] arr, int target){
        if(arr.length == 0 | arr == null) return -1;
        int left = 0, right = arr.length -1;
        while(left <= right){
           int midpoint = left +(right - left)/2;
           if(arr[midpoint] == target){
               // if the
               return midpoint;
           }

           if(target < arr[midpoint]){
               right = midpoint -1;
           }else if(target > arr[midpoint]){
               left = midpoint + 1;
           }
        }
        //if not found
        return  -1;
    }
    //recursive
    static int binarySearch(int[] arr, int left, int right, int target){
        if(left <= right){
            int midpoint = left +(right - left)/2;
            if(arr[midpoint] == target){
                return midpoint;
            }
            if(arr[midpoint] > target){
                return binarySearch(arr, left, midpoint -1, target);
            }else{
                return binarySearch(arr, midpoint + 1, right, target);
            }
        }
       return -1;
    }


    static ListNode mergeListsRecursive(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;

        if(l1.val < l2.val){
            l1.next =  mergeListsRecursive(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeListsRecursive(l1, l2.next);
            return l2;
        }

    }

    static ListNode mergeListIteretive(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode replica = new ListNode(0);
        ListNode dummy = replica;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        dummy.next = l1 == null? l2:l1;
        return replica.next;
    }
    static String amendTheSentence(String s) {
        StringBuilder builder = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isUpperCase(s.charAt(i)) && i != 0){
                builder.append(b.toString().toLowerCase() + " ");
                b.delete(0, b.length());
                b.append(s.charAt(i));
            }else{
                b.append(s.charAt(i));
            }
        }
        builder.append(b.toString().toLowerCase());

        return builder.toString().trim();
    }

    static int strStr(String haystack, String needle) {
        if(haystack.isEmpty() && needle.isEmpty()) return 0;
        if(needle.isEmpty()){
            return 0;
        } else if(haystack.isEmpty()){
            return -1;
        }
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i) == needle.charAt(j)){
                    count+=1;
                    if(count == needle.length()){
                        return i - count;
                    }
                }else{
                    count = 0;
                break;

                }
            }
        }
        return -1;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = mp.get(target - nums[i]);
                return res;
            }
            mp.put(nums[i], i);
        }

        return res;
    }

    static int[][] make_zeroes(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        return matrix;
    }

    //maximum deci-array
    public static int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, n.charAt(i)-'0');
        }
        return max;
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i])<= k){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        return false;
    }
    public static int search(int[] nums, int target) {
        int pivot = nums.length/2;
        int i = 0;
        int result = -1;
        while(i < nums.length){
            if(i <pivot){
                if(target == nums[i]){
                    result = i;
                }
            }else{
                if(target == nums[pivot]){
                    result =pivot;
                }
                pivot++;
            }
            i++;
        }
        return result;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] a = ransomNote.toCharArray();
        char[] b = magazine.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        int i = 0;
        int j = 0;
        while(i < b.length){
            if(j == a.length){
                break;
            }
            if(a[j] != b[i] && i == b.length -1){
                return false;
            }
            if(a[j] != b[i]){
                i++;
            }
            if(a[j] == b[i]){
                i++; j++;
            }
        }

        if(j != a.length){
            return false;
        }

        return true;
    }
    //palindrome partitioning1
    static int min = Integer.MAX_VALUE;
    public static int partition(String s) {
        int min = Integer.MAX_VALUE;;
        List<List<String>>res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        for(List<String>i: res){
            if(i.size() < min) min = i.size();
        }

        return min -1;
    }

    static void dfs(String s, int start, List<String> myList, List<List<String>> res){
        if(start >= s.length()) res.add(new ArrayList<>(myList));
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)) {
                myList.add(s.substring(start, end +1));
                dfs(s, end +1, myList, res);

                myList.remove(myList.size() -1);
            }
        }
    }

    static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) !=  s.charAt(j--)) return false;
        }
        return true;
    }
    //palindrome partitioning 11

    public static int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
    public static int candy(ArrayList<Integer> A) {
        int[] candies = new int[A.size()];

        for(int i=0; i < A.size(); i++){
            if(i ==0){
                candies[i] = 1;
            } else{
                if(A.get(i) > A.get(i -1)){
                    candies[i] = candies[i -1] + 1;
                }else{
                    candies[i] = 1;
                }
            }
        }

        for(int i = A.size() -2; i >= 0; i--){

            if(A.get(i) > A.get(i + 1) && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }

        }
        int sum = 0;
        for(int i: candies){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArraysProblems arraysProblems = new ArraysProblems();
        int[] c = {0,1,2,3,4,5};

        System.out.println(arraysProblems.flatlandSpaceStations(6, c));
    }

    public static int majorityElement(final List<Integer> A) {
        if(A.size() == 0) return 0;
        int max = 0;
        int o = 0;
        int  p = (int) Math.floor(A.size()/2);
        for(int i = 0; i < A.size(); i++){
            int count = 1;
            for(int j = i+1; j < A.size(); j++){
                if(A.get(i).equals(A.get(j))){
                    count +=1;
                }
            }
            if(count > p){
                if(max < count){
                    max = count;
                    o = i;
                }
            }

        }
        return A.get(o);
    }



    static boolean x = false;

    public static boolean stoneGame(int[] piles) {
        int[] allSum = new int[2];
        boolean res = play(piles, "Alex", 0, piles.length -1, new int[2]) || play(piles, "Lee", 0, piles.length -1, new int[2]);
        return res;
    }
    static boolean play(int[] piles, String name, int i, int j, int[]allSum){
        //get the maximum values
        if(i == j || i >= piles.length || j<0){

            x = allSum[0] > allSum[1];
        }

        if(name.equals("Alex") && i != j){
            if(piles[i]> piles[j]){
                allSum[0]+=piles[i];
                play(piles, "Lee", i+=1, j, allSum);
            }else{
                allSum[0]+=piles[j];
                play(piles, "Lee", i, j-=1, allSum);
            }
        }else if(name.equals("Lee") && i != j){
            if(piles[i]> piles[j]){
                allSum[1]+=piles[i];
               play(piles, "Alex", i+=1, j, allSum);
            }else{
                allSum[1]+=piles[j];
               play(piles, "Alex", i, j-=1, allSum);
            }

        }
        return x;
    }


    public static String addStrings(String num1, String num2) {
        int i = num1.length() -1;
        int j = num2.length() -1;

        int carry = 0;
        StringBuilder b = new StringBuilder();
        Stack<String>s = new Stack<>();
        while(i >= 0 && j >=0){
            int val1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int val2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
            int sum = 0;
            if(carry == 1){
                sum = val1 + val2 + 1;
                carry = 0;
            }else{
                sum = val1 + val2;
            }

            if(sum > 9){
                sum = sum%10;
                carry = 1;
            }
            s.push(String.valueOf(sum));
            i--;
            j--;
        }


        while(j >= 0 || i >= 0){
            if(j>= 0){
                int val2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
                if(carry == 1){

                    int sum = 0;
                    if(val2 + carry > 9){
                        sum = (val2 + carry) % 10;
                        s.push(String.valueOf(sum));
                        carry = 1;
                    }else{
                        sum = val2 + carry;
                        s.push(String.valueOf(sum));
                        carry = 0;
                    }
                }else{
                    s.push(String.valueOf(val2));

                }
                j--;
            }
            if(i>= 0){
                int val1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                if(carry == 1){
                    int sum = 0;
                    if(val1 + carry > 9){
                        sum = (val1 + carry) % 10;
                        s.push(String.valueOf(sum));
                        carry = 1;
                    }
                    else{
                        sum = val1 + carry;
                        s.push(String.valueOf(sum));
                        carry = 0;
                    }
                }else{
                    s.push(String.valueOf(val1));
                    carry = 0;
                }
                i--;
            }
        }
        if(carry == 1){
            s.push(String.valueOf(1));
        }

        while (!s.empty()){
            b.append(s.pop());
        }

        return b.toString();
    }
}
