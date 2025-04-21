package Baekjoon.스택큐c;

import java.util.*;
import java.lang.*;

//25 01 22
// charAt(i) chartAt(i-1)
//= tmp = pop();
public class c4_4949 {


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            if(line.equals(".")) break;

            if(checked(line)) System.out.println("yes");
            else System.out.println("no");

        }

    }
    private static boolean checked(String line) {
        Stack<Character> stack = new Stack<>();
        for (char x : line.toCharArray()) {
            if (x == '(' || x == '[') stack.push(x);

            else if (x == ')' || x == ']') {
                // 쌍이 맞으면 true
                if(stack.isEmpty()) return false;
                char tmp = stack.pop();
                if (x == ')' && tmp != '(') return false;
                else if (x == ']' && tmp != '[') return false;

            }

        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
