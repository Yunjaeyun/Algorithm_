package java_codingTest_study.section9_graph.section9_R1;
//25 03 07

import java.util.*;
public class s9_10_graph {
    static int[][]graph;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int answer=0;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        graph = new int[7+1][7+1];

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        graph[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }
    private static void DFS(int x,int y){
        if(x==7 && y==7){
            answer++;
        }else{
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(1<=nx && nx<=7 && 1<=ny && ny<=7 && graph[nx][ny]==0){
                    graph[nx][ny]=1;
                    DFS(nx,ny);
                    graph[nx][ny]=0;
                }
            }
        }
    }
}
