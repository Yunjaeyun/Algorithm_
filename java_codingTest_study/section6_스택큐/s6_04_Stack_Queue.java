package java_codingTest_study.section6_스택큐;

import java.util.Scanner;
import java.util.Stack;

// 25 01 20
// 숫자와 연산자를 어떻게 구분할것인가
// 숫자 사이에 연산자를 어떻게 끼워넣을것인가
// '0'(char) ASCII코드는 48(int)이다.
/*
Character.isDigit(x)  0~9
Character.isLetter(x) 영어
isKorean(x)
 */
public class s6_04_Stack_Queue {
    private int func(String str){
        Stack<Integer> stack=new Stack<>();
        for(char x:str.toCharArray()){
            if(Character.isDigit(x)) stack.push(x-48);
            else{
                int rt= stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt + rt);
                else if(x=='-') stack.push(lt - rt);
                else if(x=='*') stack.push(lt * rt);
                else if(x=='/') stack.push(lt / rt);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        s6_04_Stack_Queue t=new s6_04_Stack_Queue();
        Scanner sc = new Scanner(System.in);
        String line=sc.next();

        System.out.println(t.func(line));
    }
}
