package java_codingTest_study.section14_;
//250610

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s14_01_9012 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            System.out.println(isVaild(s));


        }


    }

    private static String isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if(x=='(') stack.add(x);
            else if(x==')'){
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else return "NO";
            }
        }

        if (!stack.isEmpty()) return "NO";
        return "YES";
    }

}
/*
6
(())())


)





(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

 */