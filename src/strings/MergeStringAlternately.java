package strings;

public class MergeStringAlternately {
    public static String mergeAlternately(String word1, String word2) {
        int len1= word1.length(), len2=word2.length();
        int iterationLength = len1 <len2 ? len1: len2;
        char[] array = new char[len1 + len2];
        int j =0;
        for(int i =0; i<iterationLength; i++ )
        {
            array[j++] = word1.charAt(i);
            array[j++] = word2.charAt(i);
        }
        if(len1 < len2)
        {
            for (int i = len1; i < len2; i++)
                array[j++]= word2.charAt(i);
        }
        else{
            for (int i = len2; i < len1; i++)
                array[j++] = word1.charAt(i);
        }
        return String.valueOf(array);
    }
    public static void main(String[] args) {
       String s1 ="abc",s2="pqr";
        System.out.println(mergeAlternately(s1,s2));
    }
}
