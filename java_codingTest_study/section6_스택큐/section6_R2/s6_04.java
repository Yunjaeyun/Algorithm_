package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Integer> stack = new Stack<>();

        for(char x:s.toCharArray()){ //3
            if(!Character.isDigit(x)){ // +

                int b = stack.pop();
                int a = stack.pop();


                if(x=='+') stack.push( (a + b));
                if(x=='-') stack.push( (a - b));
                if(x=='/') stack.push((a / b));
                if(x=='*') stack.push( (a * b));

            } else stack.push(x-'0');
        }
        System.out.print((int)stack.peek());
    }
}
/*


+
2
5
3

 */