package java_codingTest_study.section6_스택큐.section6_R1;
//25 03 31

import java.util.*;
public class s6_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(sol(s));
    }
    private static String sol(String s){
        String result = "";

        Stack<Character> stack = new Stack<>();
        for(char x:s.toCharArray()){
            if(x==')'){
                while (stack.pop()!='(');

            }else{
                stack.push(x);
            }
        }
        for(char x:stack){
            result+=x;
        }
        return result;
    }
}
/*


F
E

 */