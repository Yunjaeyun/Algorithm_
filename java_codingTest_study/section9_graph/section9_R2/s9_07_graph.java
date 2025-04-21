package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
public class s9_07_graph {
    static int memo[][];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        memo = new int[n + 1][n + 1];

        System.out.println(DFS(n, r));
    }
    private static int DFS(int n, int r){
        if(memo[n][r]!=0) return memo[n][r];
        if(n==r || r==0) return 1;
        else{
            int value= DFS(n - 1,r-1) + DFS(n - 1, r);
            memo[n][r]=value;
            return value;
        }
    }
}
/*
       5c3
       / \
      4c2 4c3
      /

     /
 */