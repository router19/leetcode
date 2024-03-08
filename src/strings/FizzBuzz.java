package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/fizz-buzz
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        AtomicReference<Integer> i = new AtomicReference<>(0);
        int[] a = IntStream.generate(() -> i.getAndSet(i.get() + 1)).limit(n+1).toArray();
        List<String> ans = Arrays.stream(a).mapToObj(in -> String.valueOf(in)).collect(Collectors.toList());

        for(int j=3,k=1; j < n+1; j=3*k,k++){
            ans.set(j,"Fizz");
        }

        for(int j=5,k=1; j < n+1; j=5*k,k++){
            ans.set(j,"Buzz");
        }
        for(int j=15,k=1; j < n+1; j=15*k,k++){
            ans.set(j,"FizzBuzz");
        }
        ans.remove(0);
        return ans;
    }
    public static List<String> fizzBuzzOptmized(int n) {
        List<String> ans = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            ans.add(i-1,String.valueOf(i));//Note add here and later you only set
        }
        for(int i = 2;i<n;i+=3){
            ans.set(i,"Fizz");
        }
        for(int i =4; i<n; i+=5)
            ans.set(i,"Buzz");
        for(int i=14;i<n; i+=15)
            ans.set(i,"FizzBuzz");

        return ans;

    }
    public static void main(String[] args) {
        fizzBuzzOptmized(3);
    }
}
