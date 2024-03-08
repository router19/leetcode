package strings;

public class ValidPalindrome {
    static boolean isAlphanumeric(char c ){
        if((c >= 'a' && c <='z') || (c >='0' && c<='9'))
            return true;
        return false;

    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i =0, j = s.length() -1; i <  j ; )
        {
            if(!isAlphanumeric(s.charAt(i)))
                i++;
            else if(!isAlphanumeric(s.charAt(j)))
                j--;
            else if(isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j)) && s.charAt(i) == s.charAt(j) ){
                i++;j--;
            }
            else
                return false;

        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
