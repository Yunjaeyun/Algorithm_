package java_codingTest_study.section14_;
//25 06 13

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s14_04_9935 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String b = br.readLine();
        int B = b.length();

        // 하나씩 집어넣다가, 길이 아다리가 맞으면-> 검사, 검사하다가 틀리면 break 하면 되잖아.
        // 스택에 넣은거랑 bomb랑 같으면 pop

        Stack<Character> stack = new Stack<>();
        for(int j=0;j<s.length();j++){
            stack.push(s.charAt(j));


            if(stack.size()>=B){
                boolean same=true;

                // 문자들을 검사
                for(int i=0;i<B;i++){
                    if(stack.get(stack.size()-i-1)!=b.charAt(B-i-1)){
                        same=false;
                        break;
                    }
                }
                if(same){
                    for(int i=0;i<B;i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else {
            for(char x:stack) sb.append(x);
            System.out.println(sb);
        }


    }
}

/*
        |
mirkovC4nizCC44
C4


8 size=8  i=0
7 size=8  i=1

mirkovC4

b
a
2
1

 */