package java_codingTest_study.section9_graph.section9_R2;
//25 03 20

import java.util.*;
public class s9_14_graph {
    static int board[][];
    static int dx[] = {-1,-1,0,1,1,1,  0,-1};
    static int dy[] = {0,  1,1,1,0,-1,-1,-1};

    static int n;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1) {
                    board[i][j]=0;

                    answer++;

                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
    private static void DFS(int x, int y){
            for(int i=0;i<8;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    DFS(nx, ny);

                }
        }

    }
}
