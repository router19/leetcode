package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 *
 * Solution : Start from the end of the two arrays and fill the resultant array
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
        public static void main(String[] args) {
        int nums1[] = {1,2,3,4,0,0,0};
        int nums2[] = {2,5,6};
        merge(nums1,nums1.length - nums2.length, nums2, nums2.length);
        Arrays.stream(nums1).forEach(System.out::println);
    }

}
