package arrays;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/discuss/interview-question/3100856/Fixed-Size-Sliding-Window-(Important-Questions-with-Solutions)
public class CountOccurrenceOfAnagrams {

    public static int countAnagrams(String str, String pattern){
        int ans=0;
        int left=0, right=0;
        int mapSize =0;

        Map<Character,Integer> freqMap = new HashMap<>();
        for(Character c : pattern.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0) +1);
        }
        mapSize = freqMap.size();
        while (right < str.length()){
            char ch = str.charAt(right);

            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch) -1);

            if(freqMap.get(ch) == 0)
                mapSize--;
            }

            if(right - left + 1 < pattern.length())
                right++;
            else if(right - left + 1 == pattern.length())
            {
                if(mapSize == 0)
                    ans++;

                Character leftchar = str.charAt(left);

                if(freqMap.containsKey(leftchar)){
                    freqMap.put(leftchar,freqMap.getOrDefault(leftchar,0) +1);
                    if(freqMap.get(leftchar) > 0)
                        mapSize++;
                }
            left++;right++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(countAnagrams("aabaabaa","aaba"));
    }
}
