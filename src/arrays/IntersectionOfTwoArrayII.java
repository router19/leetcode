package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrayII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] dict = new int[1001];
        int len1 = nums1.length, len2 = nums2.length;
        int len = Math.max(len1,len2);
        int i =0;
        List<Integer> ans = new ArrayList<Integer>();
        for(int num : nums1)
        {
            dict[num]++;
        }
        for(int num :nums2){
            if(dict[num] > 0)
            {
                ans.add(num);
                dict[num]--;
            }
        }


        return ans.stream().mapToInt(j->j).toArray();

    }

    public int[] intersectOptimized(int[] nums1, int[] nums2) {
        int[] f1 = new int[1001];
        for (int i: nums1)
            f1[i]++;

        int size = 0;
        for (int i = 0; i < nums2.length; i++){
            if (f1[nums2[i]] > 0){
                nums1[size++] = nums2[i];
                f1[nums2[i]]--;
            }
        }
        return Arrays.copyOfRange(nums1, 0, size);

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        Arrays.stream(intersect(nums1,nums2)).forEach(i -> System.out.print(i + " "));
    }
}
