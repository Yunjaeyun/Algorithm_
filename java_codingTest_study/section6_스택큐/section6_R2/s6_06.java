package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_06 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) q.offer(i);

        while(q.size()!=1){
            for(int i=0;i<k-1;i++){
                q.offer(q.poll());
            }
            q.poll();

        }
        System.out.print(q.peek());



    }
}
/*
3 4 5 6 7 8 1 2
 */