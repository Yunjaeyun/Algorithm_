package java_codingTest_study.section9_graph.section9_R1;
//25 03 05

import java.util.*;
public class s9_08_graph {
    static int n,f;
    static int[]ch;
    static int[]pm;

    static int[]ps; //paskal
    static int[][]memo;

    static boolean flag=false;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        pm = new int[n];
        ch = new int[n+1];
        /*
        0 1 2 3 4
          3 4 2 1
         */

        memo = new int[n + 1][n + 1];


        ps = new int[n]; //paskal
        for(int i=0;i<n;i++){
            ps[i] = combi(n - 1, i);
        }
        // 1 3 3 1


        DFS_PM(0,0);
    }
    private static void DFS_PM(int L, int sum){
        if(flag)return;
        if(sum>f) return;
        if(L==n){
            if(sum==f) {
                for(int x:pm)System.out.print(x+" ");
                flag=true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L] = i;
                    DFS_PM(L + 1,sum+(pm[L]*ps[L]));
                    ch[i]=0;
                }
            }
        }
    }
    private static int combi(int n, int r){
        if(memo[n][r]!=0) return memo[n][r];
        if(n==r||r==0) return 1;
        else{
            return memo[n][r]=combi(n-1,r)+combi(n-1,r-1);
        }
    }
}
/*
정답 3124 1234 1243인지 다 순열 다 구해봐야겠다.

 */