package java_codingTest_study.section9_graph.section9_R1;
//25 03 05

import java.util.*;
public class s9_04_graph {
    static int pm[];
    static int n, m;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//3
        m = sc.nextInt();//2

        pm = new int[m];

        DFS(0);

    }

    private static void DFS(int L) {
        if(L==m){
            for (int x:pm)System.out.print(x);
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                pm[L]=i;
                DFS(L+1);
            }
        }
    }
}

/*
뽑고 안뽑고의 이진탐색
1
        D(0,0)
       /ㅇ 1  X\
    D(1,
    이그림 아니다.

            D(0,0)
            /1     |2   \3
          D(1)       2    3
         /1 |2 3\
       11   12  13


 */
