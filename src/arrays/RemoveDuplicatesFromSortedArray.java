package arrays;

import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        Map<Integer,Integer> treeMap = new TreeMap<>();
        int k =0;
        for(int i : nums){
            treeMap.put(i,treeMap.getOrDefault(i,0));
        }

        for(Map.Entry<Integer,Integer> entry :  treeMap.entrySet()){
            nums[k++] = entry.getKey();
        }

        return k;
    }

    public static int removeDuplicatesOptimized(int[] nums) {
        int k=1;

        for(int i =1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }

        }
        return k;
    }

    public int removeDuplicatesOptimized2(int[] nums) {
        int count = 0;
        int uni = nums[0];

        for(int i =1;i<nums.length;i++){
            if( uni == nums[i]) {
                count++;
            } else {
                nums[i-count] = nums[i];
                uni = nums[i];
            }
        }

        return nums.length-count;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
}
