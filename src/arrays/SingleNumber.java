package arrays;

/**
 * https://leetcode.com/problems/single-number/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int singleNum = nums[0];
        for(int i =1; i< nums.length; i++){
            singleNum^=nums[i];
        }
        return singleNum;
    }

    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};
        System.out.println(singleNumber(nums));

    }

}
