package java_codingTest_study.section8_graph.section8_R1;
//25 03 03,04

import java.util.*;
public class s8_11_graph {
    static int[][]graph;
    static int[]ch;
    static int n,m;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        ch[1] = 1;
        dfs(1);
        System.out.println(answer);

    }

    private static void dfs(int s) {
        if(s==n){
            answer++;
        }else{
           for(int i=1;i<=n;i++){
                if(graph[s][i]==1 && ch[i]==0){
                    ch[i]=1;
                    dfs(i);
                    ch[i]=0;
                }
           }
        }
    }
}
