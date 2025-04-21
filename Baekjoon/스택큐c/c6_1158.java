package Baekjoon.스택큐c;
import java.util.*;
import java.io.*;
import java.lang.*;
public class c6_1158 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();

        func(n,k);

    }
    private static void func(int n, int k){
        Queue<Integer> q=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        result.append("<");

        for (int i = 1; i <= n; i++) q.offer(i);

        while(n>0) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            result.append(q.poll());


            if(!q.isEmpty()) result.append(", ");
            n--;
        }

        result.append(">");
        System.out.println(result);



    }
}
