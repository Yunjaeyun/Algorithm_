package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(sol(s));

    }

    private static String sol(String s) {
        Stack<Character> q = new Stack<>();
        for(char x: s.toCharArray()){
            if(x=='(') q.push('(');
            else{ // ')'
                if(q.isEmpty()) return "NO";
                q.pop();
            }
        }
        if(!q.isEmpty())return "NO";
        else return "YES";
    }
}
/*
피드백기억 pop할때 무엇인지 주의.

(
(
(
 */