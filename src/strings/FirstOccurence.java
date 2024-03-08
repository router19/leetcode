package strings;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
public class FirstOccurence {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

    }
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
