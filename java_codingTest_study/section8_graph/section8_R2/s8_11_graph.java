package java_codingTest_study.section8_graph.section8_R2;
// 25 03 14

import java.util.*;
public class s8_10_graph {

    static int [][]graph;
    static int[]ch;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n + 1];

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b]=1;
        }
        ch[1]=1;
        DFS(1);
    }
    private static void DFS(int v){
        if(){
            
        }else{

        }

    }
}
/*
for()
graph[v][i]=1
 */