class Solution {
    public String minWindow(String s, String t) {
        int start=0,end=0;

        int strStart=0,strEnd=s.length();
        boolean found= false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0; i < t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        int count = map.size();
        while(end < s.length() ){
            if(count > 0)
            {
                if(map.containsKey(s.charAt(end)))
                {
                    map.put(s.charAt(end), map.get(s.charAt(end)) -1);
                    if(map.get(s.charAt(end)) == 0){
                       count--;
                    }
                }

            }

            if(count == 0) {
                found = true;
                while(count == 0 && start <= s.length() - t.length()) {
                    if(end - start < strEnd - strStart)
                    {
                        strStart = start;
                        strEnd = end;
                    }
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
                        if (map.get(s.charAt(start)) > 0)
                            count++;
                    }
                    start++;
                }

            }
            end++;
        }
        return found ? s.substring(strStart,strEnd+1): "";
    }
}