class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<List<String>> result){
        if(start == s.length())
            result.add(new ArrayList<>(current));

        else{
            for(int i =start; i < s.length(); i++){
                if(isPalindrome(s,start,i)){
                    current.add(s.substring(start,i+1));
                    backtrack(s,i+1,current,result);
                    current.remove(current.size()-1);
                }
            }
        }
    }
    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}