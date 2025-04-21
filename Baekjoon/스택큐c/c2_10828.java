package Baekjoon.스택c;

import java.util.*;
import java.lang.*;
import java.io.*;
//25 01 22

//next와 nextline의 차이

public class c2_10828 {
    private Stack<Integer> stack=new Stack<>();

    private void check(String tc){
        String[] cmd = tc.split(" ");
        switch(cmd[0]){
            case "push":
                stack.push(Integer.parseInt(cmd[1]));
                break;

            case "pop":
                if(!stack.isEmpty()) System.out.println( stack.pop());
                else System.out.println( -1);
                break;

            case "size":
                System.out.println(stack.size()) ;
                break;

            case "empty":
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;

            case "top":
                if(stack.isEmpty()) System.out.println(-1) ;
                else System.out.println(stack.peek()) ;
                break;


        }
    }

    private void func(String [] testcase){
        for(String tc:testcase){
            check(tc);
        }
    }


    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] testcase=new String[n];
        for(int i=0; i<n;i++) testcase[i]=sc.nextLine();

        c2_10828 t=new c2_10828();
        t.func(testcase);

    }
}
