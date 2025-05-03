package java_codingTest_study.section12_etc_graph;
//25 05 01

import java.util.Arrays;
import java.util.Scanner;

public class s12_10_2468 {
    static int board[][];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int area;
    static int n;

    static boolean visited[][];

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board=new int[n][n];

        int maxHeight=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        int maxArea=0;

        for(int nowHeight=1;nowHeight<=maxHeight;nowHeight++){
            area=0;
            visited = new boolean[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(!visited[i][j] && board[i][j]>nowHeight ) {
                        area++;

                        dfs(i,j,nowHeight);
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
        }


        System.out.println(maxArea);

    }
    private static void dfs(int x, int y, int nowHeight){
        visited[x][y]=true;

        for(int i=0;i<=3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny]  && board[nx][ny]>nowHeight){
                dfs(nx, ny,nowHeight);
            }
        }
    }
}
