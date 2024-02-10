package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class MoveZeroes {

    /**
     * My solution
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = 0;
        for (int i = 0, j = 0; i < nums.length && j < nums.length; i++) {
            if (nums[j] != 0 && nums[i] == 0) {
                j = i;
            }

            if (nums[i] != 0 && nums[j] == 0 && i != j) {
                n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
                j++;
            }
        }
    }

    /**
     * Using snowball size
     * Basically maintain the size of snowBall and whenever we encounter a non zero element
     * we need to move that element to the left
     * hence swap that with the left most zero element
     * @param nums
     */
    public static void moveZeroesUsingSnowBallSize(int nums[])
    {
        int snowBallSize = 0;
        int temp;
        for(int i =0; i< nums.length; i++){
            if(nums[i] == 0)
                snowBallSize++;
            else if(snowBallSize > 0){
                temp = nums[i];
                nums[i] = 0;
                nums[i-snowBallSize] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1};
        Arrays.stream(nums).forEach(System.out::print);
        moveZeroesUsingSnowBallSize(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
