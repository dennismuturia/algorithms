package com.dennis;

//Encoposses string problems
public class StringProblems {
    public String longestPalindrome(String s) {
        //use dynamic programming
        int n = s.length();
        boolean[][] table = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        int start = 0;
        for (int i = 0; i < n -1; i++) {
            if(s.charAt(i) == s.charAt( i+1)){
                table[i][i +1] = true;
                start = i;
                maxLength = 2;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 3; i <=n ; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = j + i -1;
                if(table[j +1][k -1] && s.charAt(j) == s.charAt(k)){
                    table[j][k] = true;
                    if(i > maxLength){
                        start = j;
                        maxLength = i;
                    }
                }
            }

        }
        return s.substring(start, s.length() - start);
    }
}
