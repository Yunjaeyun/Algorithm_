package Baekjoon.스택큐c;

import java.util.*;
import java.lang.*;
public class c10_딩코_숙제_프로그래머스_올바른괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack=new Stack<>();
            for(char x:s.toCharArray()){
                if(x=='(') stack.push('(');
                else { //           ')'
                    if(stack.isEmpty()) {
                        answer=false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) answer=false;

            return answer;
        }
    }
}
