package java_codingTest_study.section9_graph;
//25 02 13

import java.util.*;
public class s9_06_graph {
    static int n,m;
    static int[]arr;
    static int[]visited,pm;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new int[n];
        pm = new int[m];

        arr=new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        DFS(0);
    }
    private static void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){

                if (visited[i]==0){
                    visited[i]=1;
                    pm[L] = arr[i];

                    DFS(L + 1);
                    visited[i] = 0;
                }

            }
        }
    }
}
