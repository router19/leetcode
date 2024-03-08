package arrays;

public class SubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int i=0,j=0;
        int sum =0;
        int candidates =0;
        while(j < nums.length) {
            sum += nums[i];
            if(sum < k){
                j++;
            }
            else if(sum == k){
                candidates++;
                j++;
            }
            else {
                while (sum > k){
                    sum -= nums[i];
                    i++;
                }
                if(sum == k)
                    candidates++;
                j++;
            }
        }
        return candidates;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1}, 0));
    }
}
