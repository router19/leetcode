package arrays;

import java.util.*;

public class ThreeSum {
     class Triplet{
        int i,j,k;

         public Triplet(int i, int i1, int i2) {
             this.i =i;
             this.j = i1;
             this.k = i2;
         }

         @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return i == triplet.i && j == triplet.j && k == triplet.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }

        public List<Integer> toList(){
             List<Integer> list = new ArrayList<>();
             list.add(i);
             list.add(j);
             list.add(k);
             return list;
        }
    }
    public  List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> set = new HashMap<>();
        List<Triplet> ans = new ArrayList<>();
        for(int i =0;i< nums.length; i ++) {
            set.put(nums[i],i);
        }

        for(int i =0; i < nums.length-1; i++){
            for(int j =i+1; j < nums.length; j++){
                if(set.containsKey(-1 * (nums[i] + nums[j]))  && set.get(-1 * (nums[i] + nums[j])) != i
                && set.get(-1 * (nums[i] + nums[j])) != j && i  != j) {
                    int arr[] = new int[]{nums[i], nums[j], -1 * (nums[j] + nums[i])};
                    Arrays.sort(arr);
                    Triplet triplet = new Triplet(arr[0],arr[1],arr[2]);
                    if(!ans.contains(triplet))
                        ans.add(triplet);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Triplet triplet : ans){
            res.add(triplet.toList());
        }
        return res;
    }
    //
    /*
    1. Sort the array
    2. Iterate over all the elements, take ith element as target and search for other two forward
    3. Start search for other two from front and back for target as nums[i]
    4. once found, make sure to avoid same number 2 and number 3 by skipping all same elements
    5. similarly avoid all same nums[i] as the target

     */
    public static List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i =0; i < nums.length; i++) {
            int front = i+1;
            int back = nums.length-1;
            int target = -nums[i];

            while(front < back){
                int sum = nums[front] + nums[back];
                if(sum < target)
                    front++;
                else if(sum > target)
                    back--;
                else{
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i],nums[front],nums[back]));
                    res.add(triplet);
                    //now avoid all duplicates of nums[front]
                    while(front < back && nums[front] == triplet.get(1)) front++;

                    //
                    while(front < back && nums[back] == triplet.get(2)) back--;
                }
            }

            while(i +1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum th = new ThreeSum();
//        System.out.println(th.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumOptimized(new int[]{-1,0,1,2,-1,-4}));
    }
}
