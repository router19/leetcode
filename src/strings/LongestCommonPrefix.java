package strings;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix
public class LongestCommonPrefix {

    /**
     * 1. Sort
     * 2. Just compare first and last string which has a common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length -1];
        StringBuilder ans = new StringBuilder();

        for(int i =0; i < Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    // 1. chose the first string as prefix
    // 2 now for each string if prefix matches keep moving to next string, else try deleting characters
    // Time Complexity O(N + M ) , whr N = lengthof array, M= length of first string
    public static String longestCommonPrefixOpt(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if(strs.length > 0)
            prefix.append(strs[0]);
        int i =1;
        while(!prefix.isEmpty() && i < strs.length){
            if(strs[i].startsWith(prefix.toString()))
                i++;
            else
                prefix.deleteCharAt(prefix.length() -1);
        }

        return prefix.toString();
    }
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(strs[0].startsWith("flower"));
        System.out.println(longestCommonPrefixOpt(strs));
    }

}
