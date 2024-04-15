package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {


    public  static int getMaxProfit(int arr[][], int w){
        Arrays.sort(arr,(i2,i1) -> Double.compare(i1[0]/i1[1], i2[0]/i2[1] ));
//        Arrays.sort(arr, Comparator.comparingDouble(i -> i[0] / i[1]));
        int capacity = w;
        int profit = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(capacity - arr[i][1] >=0){
                capacity -= arr[i][1];
                profit += arr[i][0];
            }
            else{
                double fraction
                        = ((double)capacity / (double)arr[i][1]);
                profit += arr[i][0] * fraction;
                break;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
    int arr[][] = {{100, 20}, {60, 10}, {120, 30}};
    int w = 50;
        System.out.println("max profits "+ getMaxProfit(arr,w));
    }
}
