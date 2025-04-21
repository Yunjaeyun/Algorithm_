package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_05 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int cnt=0;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push('(');
            else{ // ')'
                if(s.charAt(i-1)=='(') { // ()
                    stack.pop();
                    cnt += stack.size();
                }else {
                    stack.pop();
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);
    }
}
