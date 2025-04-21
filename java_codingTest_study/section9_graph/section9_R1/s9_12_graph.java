package java_codingTest_study.section9_graph.section9_R1;
//25 03 07

import java.util.*;
class Point{
    int x, y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class s9_12_graph {
    static int[][]board;
    static int[][]dis;

    static int[]dx={-1,0,1,0};
    static int[]dy={0,1,0,-1};

    static Queue<Point2> q = new ArrayDeque<>();

    static int n,m;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         m = sc.nextInt();
         n = sc.nextInt();

        dis=new int[n][m];
        board = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                board[i][j] = sc.nextInt();
//                dis[i][j] = sc.nextInt(); wrong
                if(board[i][j]==1) {
                    q.offer(new Point2(i, j));
                }
            }
        }

        BFS();

        boolean complete=true;

        int answer=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0) {
                    complete = false;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                answer = Math.max(answer, dis[i][j]);
            }
        }
        if(!complete) System.out.println(-1);
        else System.out.println(answer);

    }
    private static void BFS(){

        while(!q.isEmpty()){
            Point2 cur = q.poll();
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<m && board[nx][ny]==0 ){
                    board[nx][ny]=1; //익게됨
                    dis[nx][ny]=dis[cur.x][cur.y]+1;

                    q.offer(new Point2(nx, ny));
                }
            }
        }
    }
}
