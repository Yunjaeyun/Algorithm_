package java_codingTest_study.section6_스택큐.section6_R1;
//25 04 02

import java.util.*;
public class s6_05 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int answer=0;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='(') {
                stack.push('(');
            } else{ // )
                if(s.charAt(i-1)=='(') {
                    stack.pop();
                    answer += stack.size();
                }else {
                    stack.pop();
                    answer++;
                }
            }
//            System.out.println(answer);

        }
        System.out.println(answer);
    }
}
