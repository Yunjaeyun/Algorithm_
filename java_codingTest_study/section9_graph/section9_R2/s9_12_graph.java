package java_codingTest_study.section9_graph.section9_R2;
//25 03 20
import java.util.*;
class Point6{
    int x, y;

    Point6(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
public class s9_12_graph {
    static int[][]board;
    static int[][]dis;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int m, n;

    static Queue<Point6> q = new ArrayDeque<>();

    static boolean IsItAlready_=true;
    static boolean NotPerfect=false;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        dis = new int[n][m];

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==1) q.offer(new Point6(i, j));
                else IsItAlready_=false; // 이미 다 익은건 아님.

            }
        }

        BFS();
        int answer=0;

        outer:
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(board[i][j]==0) {
                    NotPerfect=true;
                    break outer;
                }

                answer = Math.max(answer, dis[i][j]);
            }
        }

        if(IsItAlready_) System.out.println(0);
        else{
            if(NotPerfect) System.out.println(-1);
            else System.out.println(answer);
        }


    }
    private static void BFS(){
        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                Point6 cur = q.poll();

                for(int j=0;j<=3;j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(0<=nx && nx<n && 0<=ny && ny<m && board[nx][ny]==0){
                        board[nx][ny]=1;
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;

                        q.offer(new Point6(nx, ny));
                    }
                }
            }
        }
    }
}
