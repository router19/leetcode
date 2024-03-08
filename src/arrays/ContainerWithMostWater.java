package arrays;
///https://leetcode.com/problems/container-with-most-water
public class ContainerWithMostWater {

    /**
     * Get the min height
     * area = max (current, (right-left) * min height
     *
     * Keep iterating if height of left or right os less than curr min height
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max_water = 0;
        int left =0, right = height.length-1;
        while(left < right)
        {
            int h =  Math.min(height[left],height[right]);

            max_water = Math.max(max_water, (right-left) * h);

            while((height[left]<=h) && left<right){
                left++;
            }
            while((height[right]<=h) && left<right){
                right--;
            }
        }
        // System.gc();
        return max_water;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
