package java_codingTest_study.section6_스택큐.section6_R1;
//25 03 31

import java.util.*;
public class s6_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(sol(s));
    }
    private static String sol(String s){
        Stack<Character> stack = new Stack<>();

        for(char x:s.toCharArray()){
            if(x=='(') stack.push('(');
            else {
                if(stack.isEmpty())return "NO";
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}
