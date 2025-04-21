package Baekjoon.스택큐c;


import java.util.*;
import java.lang.*;

// 여러개의 입력을 받는경우
// empty일시 pop하면 error
//25 01 22
public class c1_9012 { //()()
    private String check(String tc){
        Stack<Character> stack=new Stack<>();

        for(char x:tc.toCharArray()){
            if(x=='(') stack.push(x);
            else { // ')'
                if(stack.isEmpty()) return "NO"; //pop할때 empty라면 error
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        return "YES";


    }
    private void func(String [] testcase){
        for(String tc:testcase){
            System.out.println(check(tc));
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String [] testcase=new String[t];
        for(int i=0; i<t;i++) testcase[i]=sc.next();

        c1_9012 T=new c1_9012();
        T.func(testcase);
    }
}
