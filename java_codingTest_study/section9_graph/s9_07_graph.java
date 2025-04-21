package java_codingTest_study.section9_graph;
//25 02 17

import java.util.Scanner;
public class s9_07_graph {
    static int[][] memo;
    private static int DFS(int n,int r){
        if(r==0 || n==r){
            return 1;
        }else{
            if(memo[n][r]>0)
                return memo[n][r];
            int value = DFS(n - 1, r - 1) + DFS(n - 1, r);
            memo[n][r]=value;
            return memo[n][r];
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();


        memo = new int[n+1][n+1];
        System.out.println(DFS(n, r));
    }
}
/*
dfs 메서드안에 [][]넣으면 재귀호출할때마다 visited[][]가 초기화되서 제대로 작동안됨.

line 13-1 그다음은 13-2
 */