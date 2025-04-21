package java_codingTest_study.section6_스택큐;

import java.util.Scanner;
import java.util.Stack;

//25 01 20
/*

)
(
pop한뒤 이전에 쌓인 막대기는->레이저 앞쪽에서 이미 시작된 막대기3개를 의미(=레이저에 의해 짤릴 막대기)
(
(
(

 */
public class s6_05_Stack_Queue {
    private int func(String str){
        int answer=0;
        // str 하나씩 받으면서

        // () 인접한 괄호 한쌍은 레이저임. 즉, ()인접한 한쌍이 확인되면, stack에 쌓인  '(' 갯수만큼 잘린거임 (+stack.size)

        // 그렇지 않다면, 즉 ()이 완성되었으나(=pop조건을 충족), 인접한게 아니라면 막대가 끝났다는 의미.(+1)그냥 pop
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push('(');
            else{
                stack.pop();
                if(  str.charAt(i-1)=='(') answer+=stack.size();
                else answer+=1;                        //!isempty()추가를 하면안됨. 추가해버리면-> 막대기가 끝나는 지점에서+1 못먹음
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        s6_05_Stack_Queue t=new s6_05_Stack_Queue();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(t.func(str));

    }
}
