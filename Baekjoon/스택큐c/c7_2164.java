package Baekjoon.스택큐c;
import java.util.*;
import java.io.*;
import java.lang.*;

//25 01 25
public class c6_2164 {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(func(n));
    }

    private static int func(int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n;i++) q.offer(i);

        while(q.size()>1){
            q.poll();
            q.offer(q.poll());

        }
        return q.peek();

    }
}
