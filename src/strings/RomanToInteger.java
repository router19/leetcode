package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/solutions/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class RomanToInteger {

    private static Map<Character,Integer> symbolValueMap = new HashMap<>();
    static {
        symbolValueMap.put('I',1);
        symbolValueMap.put('V',5);
        symbolValueMap.put('X',10);
        symbolValueMap.put('L',50);
        symbolValueMap.put('C',100);
        symbolValueMap.put('D',500);
        symbolValueMap.put('M',1000);

    }


    /**
     * when a smaller value appears before a larger value, it represents subtraction,
     * while when a smaller value appears after or equal to a larger value, it represents addition.
     * examples "IX" and "XI"
     * @param s
     * @return
     */
    private static int romanToIntOptimised(String s){
        int value=0;
        for(int i =0; i < s.length(); i++){
            if(i < s.length() -1 && symbolValueMap.get(s.charAt(i)) < symbolValueMap.get(s.charAt(i+1))){
                value -= symbolValueMap.get(s.charAt(i));
            }
            else{
                value += symbolValueMap.get(s.charAt(i));
            }
        }
        return value;
    }

    private static int romanToIntOptimized2(String s){
        int value =0;
        s = s.replace("IV","IIII").replace("IX","VIIII");
        s = s.replace("XL","XXXX").replace("XC","LXXXX");
        s = s.replace("CD","CCCC").replace("CM","DCCCC");

        for(char c: s.toCharArray()){
            value += symbolValueMap.get(c);
        }
        return value;
    }

    public static int romanToInt(String s) {
        int value = 0;

        for(int i =0; i <s.length(); i++) {
            if (s.charAt(i) == 'I' && i + 1 < s.length())
            {
                if(s.charAt(i+1) == 'V'){
                    i++;
                    value +=4;
                    continue;
                }
                if(s.charAt(i+1) == 'X'){
                    i++;
                    value +=9;
                    continue;
                }
            }
            if (s.charAt(i) == 'X' && i + 1 < s.length())
            {
                if(s.charAt(i+1) == 'L'){
                    i++;
                    value +=40;
                    continue;
                }
                if(s.charAt(i+1) == 'C'){
                    i++;
                    value +=90;
                    continue;
                }
            }
            if (s.charAt(i) == 'C' && i + 1 < s.length())
            {
                if(s.charAt(i+1) == 'D'){
                    i++;
                    value +=400;
                    continue;
                }
                if(s.charAt(i+1) == 'M'){
                    i++;
                    value +=900;
                    continue;
                }
            }
            value += symbolValueMap.get(s.charAt(i));
        }
        return value;
    }


    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToIntOptimized2(s));

    }

}
