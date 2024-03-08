package arrays;

import java.util.*;

//https://leetcode.com/problems/merge-intervals
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        // Sort by ascending starting point
        //Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] currInterval = intervals[0];
        result.add(currInterval);
        for(int[] interval : intervals){
            if(interval[0] <= currInterval[1]){// Overlapping intervals, move the end if needed
                currInterval[1] = Math.max(currInterval[1],interval[1]);
            }
            else{// Disjoint intervals, add the new interval to the list
                currInterval = interval;
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] mergeOptimized(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }

        int[] range = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[] {start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[] {start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        for(int[] interval: mergeOptimized(new int[][]{{1,3},{2,6},{8,10}, {15,18}}))
            System.out.print("[" + Arrays.toString(interval) + " " );
        System.out.println("]");
    }
}
