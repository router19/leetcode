package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/plus-one/description/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class PlusOne {
    public static int[] plusOneOptimized(int[] digits) {
        for(int i = digits.length-1; i>= 0;i--)
        {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;

    }


    public static int[] plusOne(int[] digits) {
        int i = digits.length,carry=1;
        while(i >0)
        {
            digits[i-1] +=carry;
            if(digits[i-1] %10 == 0){
                carry =1;
                digits[i-1] = 0;
                i--;

            }
            else{
                carry =0;
                break;
            }

        }
        if(carry == 1) {
            List<Integer> ans =new ArrayList<>();
            ans.add(carry);
            ans.addAll(Arrays.stream(digits).boxed().collect(Collectors.toList()));
            return ans.stream().mapToInt(in->in).toArray();
        }
        return digits;

    }
    public static int[] plusOneWrong(int[] digits) {

        List<Integer> list = Arrays.stream(digits).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        digits = list.stream().mapToInt(i->i).toArray();
        int carry =0;
        for(int i=0; i< digits.length ; i++)
        {
            digits[i] = digits[i] + carry + 1;
            if(digits[i] %10 == 1)
                carry =1;
        }
        if(carry == 1) {
            List<Integer> collect = Arrays.stream(digits).boxed().collect(Collectors.toList());
            collect.add(carry);
            Collections.reverse(collect);
            return collect.stream().mapToInt(i-> i).toArray();

        }
        Collections.reverse(Arrays.asList(digits));
        return digits;
    }
    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        digits = plusOneOptimized(digits);
        Arrays.stream(digits).forEach(System.out::println);
    }
}
