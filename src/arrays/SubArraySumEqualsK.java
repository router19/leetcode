package arrays;


//This solution only works for given array consisting of only +ve numbers
//Note : We assumed and removed ith element when sum becomes > k,, which is not true in case of -ve numbers as sum would
//not always increase


public class SubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int i=0,j=0;
        int sum =0;
        int candidates =0;
        while(j < nums.length) {
            sum += nums[j];
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
        System.out.println(subarraySum(new int[]{4,1,1,1,2,3,5}, 3));
    }
}
