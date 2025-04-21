package java_codingTest_study.section9_graph;
//25 02 17

import java.util.*;
public class s9_08_graph {
    static int n,f;
    static int [] Combination, visited, permutation;
    static int[][]memo;
    static boolean flag=false;

    private int combi(int n,int r){
        if(n==r||r==0){
            return 1;
        }else{
            if(memo[n][r]>0)
                return memo[n][r];
            int value = combi(n - 1, r - 1) + combi(n - 1, r);
            memo[n][r]= value;
            return memo[n][r];
        }
    }
    private void DFS(int L, int sum){
        if(flag) return; //***** 왜 이문제만 이코드가 있는가
        if(L==n){
            if(sum==f){
                for(int x:permutation) System.out.print(x+" ");
                flag=true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    permutation[L]=i;
                    DFS(L+1,sum+(Combination[L]*permutation[L]));
                    visited[i]=0;
                }
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();

        permutation =new int[n];
        Combination = new int[n];
        visited = new int[n + 1];
        memo=new int[n + 1][n + 1];

        s9_08_graph t = new s9_08_graph();
        for(int i=0; i<n;i++){
           Combination[i]= t.combi(n-1,i);
        }

        t.DFS(0,0);

    }
}
