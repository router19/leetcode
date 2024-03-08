package strings;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack();
        char popchar ;
        for(char c: s.toCharArray()){
            if(c == '(' || c=='{' || c=='[')
                st.push(c);
            else {
                if (!st.isEmpty()) {
                    popchar = st.pop();
                    if (c == ')' && popchar != '(')
                        return false;

                    else if (c == ']' && popchar != '[')
                        return false;
                    else if (c == '}' && popchar != '{')
                        return false;
                }
                else return false;
            }
        }
        if(st.isEmpty())
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValid(")))"));
    }
}
