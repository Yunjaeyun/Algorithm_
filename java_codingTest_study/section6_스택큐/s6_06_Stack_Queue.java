package java_codingTest_study.section6_스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//25 01 21
public class s6_06_Stack_Queue {
    private int func(int n,int k){
        int answer=0;

        Queue<Integer> q=new LinkedList<>();
        for(int i=1; i<= n;i++) q.offer(i);
        while(!q.isEmpty()){
            for(int i=1; i<k;i++) q.offer(q.poll());
            q.poll();
            if(q.size()==1) answer=q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        s6_06_Stack_Queue t=new s6_06_Stack_Queue();
        System.out.println(t.func(n,k));

    }
}
