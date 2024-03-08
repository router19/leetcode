class Solution {
    public int maxArea(int[] height) {
       int max_water = 0;
       int i =0, j = height.length-1;
       while(i < j)
        {
            int h =  Math.min(height[i],height[j]);
            
            max_water = Math.max(max_water, (j-i) * h);

            while((height[i]<=h) && i<j){
                i++;
            }
            while((height[j]<=h) && i<j){
                j--;
            }
        }
        System.gc();
        return max_water;
    }
}