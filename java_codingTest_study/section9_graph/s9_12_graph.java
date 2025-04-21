package java_codingTest_study.section9_graph;
//25 02 18
//* 시작 for문으로 일일이 찾나? 끝?어떻게 구현할것인가
import java.util.*;
public class s9_12_graph {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0, 1,0,-1};
    static int board[][];
    static int dis[][];
    static Queue<Point> q ;
    static int m,n;

    static class Point{
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    private void BFS(){
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int nx= tmp.x+ dx[i];
                int ny= tmp.y+ dy[i];

                if(1<=nx && nx<=n && 1<=ny && ny<=m && board[nx][ny]==0){
                    board[nx][ny]=1;
                    dis[nx][ny]= dis[tmp.x][tmp.y]+1;
                    q.offer(new Point(nx, ny));
                }
            }

        }

    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        q= new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==1) q.offer(new Point(i, j));
            }
        }

        s9_12_graph t = new s9_12_graph();

        t.BFS();

        int answer = Integer.MIN_VALUE;
        boolean flag=true;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(board[i][j]==0) flag=false;
            }
        }
        if(flag){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }



    }
}
