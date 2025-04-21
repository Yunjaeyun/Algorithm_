package java_codingTest_study.section6_스택큐;

import java.util.Scanner;
import java.util.Stack;

/*
후입선출
 */
// 25 01 16
// (())()   y
// (()()))  n
// (()(()))(() n
public class s6_01_Stack_Queue {
    private String function(String line){

        Stack<Character> stack=new Stack<>();
        for(int i=0; i<line.length();i++){
            if (line.charAt(i)=='(')
                stack.push(line.charAt(i));
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s6_01_Stack_Queue t=new s6_01_Stack_Queue();
        int n=sc.nextInt();

        for(int i=0; i<n; i++){
            String input = sc.next();
            String answer=t.function(input);
            System.out.println(answer);
        }

    }
}
