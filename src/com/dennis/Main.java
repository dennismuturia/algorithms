package com.dennis;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Graph{
        int Vertices;
        LinkedList<Integer> adj_list[];

        Graph(int val){
            Vertices = val;
            adj_list = new LinkedList[val];
            for (int i = 0; i <val ; i++) {
                adj_list[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w){
            adj_list[v].add(w);
        }

        void DFS(int v){
            boolean[] visited = new boolean[Vertices];
            DFS_helper(v, visited);
        }

        private void DFS_helper(int v, boolean[] visited) {
            visited[v] = true;
            System.out.println("Visited v: "+ v);

            Iterator<Integer>i = adj_list[v].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    DFS_helper(n, visited);
                }
            }
        }
    }

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

    public static void main(String[] args) {



        int[] intervals1 = {4,5,6,0,0,0};
        int[] intervals2 = {1,2,3};
        ArraysProblems a = new ArraysProblems();
         a.merge(intervals1, 0, intervals2, 1);
        for (int i = 0; i < intervals1.length; i++){
            System.out.println(intervals1[i]);
        }


        /*
        Graph newGraph = new Graph(3);
        newGraph.addEdge(1, 0);
        newGraph.addEdge(1, 2);
        newGraph.addEdge(2, 2);
        newGraph.addEdge(0, 1);
        newGraph.addEdge(0, 1);
        newGraph.addEdge(2, 0);

        newGraph.DFS(0);

         */


        /*
        // define edges of the graph
        List<Edge>edgesList = Arrays.asList(new Edge(0, 1,2), new Edge(0, 2, 4));
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 2),new Edge(0, 2, 4),
                new Edge(1, 2, 4),new Edge(2, 0, 5), new Edge(2, 1, 4),
                new Edge(3, 2, 3), new Edge(4, 5, 1),new Edge(5, 4, 3));
        // call graph class Constructor to construct a graph
        Graph graph = new Graph(edges);
        // print the graph as an adjacency list
        Graph.printGraph(graph);
         */

    }
}
