package java_codingTest_study.section8_graph.section8_R2;
// 25 03 14

import java.util.*;
public class s8_11_graph {

    static int [][]graph;
    static int[]ch;
    static int n,m;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n + 1];

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b]=1;
        }
        ch[1]=1;
        DFS(1);
        System.out.println(answer);
    }
    private static void DFS(int v){
        if(v==n){
            answer++;
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0 && graph[v][i]==1){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }

    }
}
/*
for()
graph[v][i]=1

ch 1 2 3 4 5
   1 1 0 0 0


d(2) i=4
d(1)
 */