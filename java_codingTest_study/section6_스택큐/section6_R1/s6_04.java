package java_codingTest_study.section6_스택큐.section6_R1;
//25 04 02

import java.util.*;
public class s6_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) stack.push(s.charAt(i)-'0');
            else{
                int a = stack.pop();
                int b = stack.pop();

                if(s.charAt(i)=='-') stack.push(b-a);
                else if(s.charAt(i)=='+') stack.push(a+b);
                else if(s.charAt(i)=='*') stack.push(a*b);
                else if(s.charAt(i)=='/') stack.push(b/a);
            }

        }
        System.out.println(stack.peek());
    }
}
/*
-
9
21
 */