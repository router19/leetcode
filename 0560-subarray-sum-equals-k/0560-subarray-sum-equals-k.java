class Solution {
    public int subarraySum(int[] nums, int k) {
        int i=0,j=0;
        int currSum =0;
        int candidates =0;
        
        Map<Integer,Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0,1);
        for(int num : nums){
            currSum += num;

            if(sumCountMap.containsKey(currSum - k))
                candidates += sumCountMap.get(currSum - k);

            sumCountMap.put(currSum,sumCountMap.getOrDefault(currSum,0) +1);        
        }

        return candidates;
    }
}