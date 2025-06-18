package java_codingTest_study.section14_;
//25 06 11

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s14_02_10799 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] c = s.toCharArray();

        int cnt=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            // 이전문제랑 비슷

            // 레이저면 +=
            // 막대기 끝이면

            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty() && s.charAt(i-1)=='('){
                    stack.pop();
                    cnt += stack.size();
                }else if(!stack.isEmpty() && s.charAt(i-1)==')') {
                    stack.pop();
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*

()(((()())(())()))(())


))


(
(



 */