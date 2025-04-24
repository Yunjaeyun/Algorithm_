package java_codingTest_study.section9_graph;
//25 04 22 1230

import java.util.*;
public class s9_06_graph_2 {
    static int[]visited,pm;
    static int[]arr;
    static int n,m; // 3 2
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

        visited = new int[n];
        pm = new int[m];

        arr=new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        dfs(0);
    }
    private static void dfs(int L){
        if(L==m){
            for(int x:pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    pm[L] = arr[i];

                    dfs(L + 1);
                    visited[i]=0;
                }
            }
        }
    }
}
/*
visit
0 1 2
3 6 9
v

       0
       /3|6\9
       1
     /3|6\9
     2

   0 1
pm 3 6

d(1)for 6
d(0)

 */