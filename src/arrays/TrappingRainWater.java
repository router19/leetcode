package arrays;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public static int trap(int[] height) {
        int capcity =0;

        int left =0,right = height.length-1, left_max=0,right_max=0;

        while (left < right){
            if(height[left] < height[right])
            {
                if(height[left] >= left_max)
                    left_max = height[left];
                else
                    capcity += left_max - height[left];
                left++;
            }
            else{
                if(height[right] >= right_max)
                    right_max = height[right];
                else
                    capcity += right_max - height[right];
                right--;
            }
        }
        return capcity;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
