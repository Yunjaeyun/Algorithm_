package java_codingTest_study.section9_graph.section9_R1;
//25 03 05

import java.util.*;
public class s9_03_graph {
    static int[] score_arr;
    static int[] time_arr;
    static int n,m;
    static int answer=0;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();

        score_arr = new int[n];
        time_arr = new int[n];

        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int t = sc.nextInt();

            score_arr[i]=s;
            time_arr[i]=t;

        }
        DFS(0, 0, 0);
        System.out.println(answer);

    }
    private static void DFS(int L, int score, int time){
        if(time>m)return;
        if(L==n){
            answer = Math.max(answer, score);
        }else{
            DFS(L + 1,score+score_arr[L],time+time_arr[L]);
            DFS(L + 1,score,time);
        }
    }
}
/*
score 10 25 15 6 7
time  5  12 8  3 4

o or x
{ }



                D(0,0)
                / 1  \
              D(1,10,5) D(1,0,0)

피드백 :배열정의하고 바로-> 초기화시킬것


 */