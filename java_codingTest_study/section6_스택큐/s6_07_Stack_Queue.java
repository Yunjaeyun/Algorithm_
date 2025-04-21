package java_codingTest_study.section6_스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 과목의 순서가 틀림을 어떻게 정의할것인가 -  contains로 필수순서만 확인

//25 01 21
public class s6_07_Stack_Queue {
    private String func(String must,String plan){
        Queue<Character> q=new LinkedList<>();

        for(char x:must.toCharArray()) q.offer(x);

        for(char x:plan.toCharArray()){
            if(q.contains(x)){
                if(q.poll()!=x) return "NO";

            }
        }
        if(!q.isEmpty()) return "NO";

        return "YES";


    }


    public static void main(String[] args) {
        s6_07_Stack_Queue t=new s6_07_Stack_Queue();
        Scanner sc = new Scanner(System.in);
        String must=sc.next();
        String plan = sc.next();
        System.out.println(t.func(must, plan));

    }
}
