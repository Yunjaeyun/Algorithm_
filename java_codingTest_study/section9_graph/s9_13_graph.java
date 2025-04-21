package java_codingTest_study.section9_graph;
//25 02 18
// if 문 완성?
import java.util.*;
public class s9_13_graph {
    static int n;
    static int[][]board;
    static int[] dx = {-1,-1,0,1,1, 1, 0,-1};
    static int[] dy = {0, 1, 1,1,0,-1,-1,-1};
    static int answer=0;
    private static void DFS(int x, int y){
        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1){
                board[nx][ny] = 0;
                DFS(nx, ny);


            }
        }
    }

    private static void solution(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1) {
                    answer++;

                    board[i][j]=0; //초기값
                    DFS(i,j);
                }
            }
        }

    }
    public static void main(String[]args){
        // 이중for문 돌다가 1만나면 dfs
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }
        solution();
        System.out.println(answer);

    }
}
