package java_codingTest_study.section9_graph.section9_R2;
//25 03 20

import java.util.*;
public class s9_10_graph {
    static int board[][];
    static int answer=0;
    static int dx[] = {-1,0,1,0};
    static int dy[]=  {0,1,0,-1};
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        board = new int[7 + 1][7 + 1];

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1]=1;
        DFS(1, 1);
        System.out.println(answer);
    }
    private static void DFS(int x, int y){
        if(x ==7 && y==7){
            answer++;
        }else{
            for(int i=0;i<=3;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( 1<=nx &&  nx<=7 && 1<=ny && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    DFS(nx, ny);
                    board[nx][ny]=0;

                }
            }
        }
    }
}
