package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_02 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Character> q = new Stack<>();
        for(char x:s.toCharArray()){
            if(x==')'){
                while(q.pop()!='('){

                }

            } else q.push(x);
        }
        for(char x:q) System.out.print(x);
    }
}
/*

(A(BC)D)EF(G(H)(IJ)K)LM(N)

n
(
m
l
f
e

 */