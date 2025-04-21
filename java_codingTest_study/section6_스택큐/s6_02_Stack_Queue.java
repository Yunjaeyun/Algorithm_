package java_codingTest_study.section6_스택큐;

import java.util.Scanner;
import java.util.Stack;

// (A(BC)D)EF(G(H)(IJ)K)LM(N)
// 2025 01 20
public class s6_02_Stack_Queue {
    public String solution(String str){
        String answer = "";
        Stack<Character> stack=new Stack<>();
        for(char x:str.toCharArray()){
            if (x==')'){
                while(stack.pop()!='(');
            }else{
                stack.push(x);
            }
        }
        for(int i=0; i<stack.size();i++){
            answer+= stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        s6_02_Stack_Queue t=new s6_02_Stack_Queue();
        Scanner sc = new Scanner(System.in);
        String str=sc.next();

        System.out.println(t.solution(str));

    }
}
