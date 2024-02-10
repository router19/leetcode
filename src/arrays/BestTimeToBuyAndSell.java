package arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSell {
    public static int maxProfit(int[] prices) {
    int max_profit=0;
    int left=0,right =1;

    while(right < prices.length){
        if(prices[left] < prices[right]){
            max_profit = Math.max(prices[right] - prices[left],max_profit);
        }
        else{
            left = right;
        }
        right++;

    }

    return max_profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
