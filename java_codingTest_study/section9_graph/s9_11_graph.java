package java_codingTest_study.section9_graph;
//25 02 17 Main

import java.util.*;
import java.lang.*;

public class s9_11_graph {
    static int[][] board,dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,  1, 0, -1};

    class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void BFS(int x,int y){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        board[x][y]=1;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for(int i=0;i<4;i++){
                int nx=tmp.x + dx[i];
                int ny=tmp.y + dy[i];

                if(1<=nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                    q.offer(new Point(nx,ny));


                }
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        board = new int[7 + 1][7+1];
        dis   = new int[7 + 1][7+1];

        for(int i=1;i<=7;i++){
            for(int j=1; j<=7;j++){
                board[i][j] = sc.nextInt();
            }
        }
        s9_11_graph t = new s9_11_graph();
        t.BFS(1, 1);

        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}


/*

    # BFS
    # 1 루트노드를 큐에 넣습니다
    # 2 현재 큐의 노드를 빼서 visited에 추가한다.
    # 3 현재 방문한 노드와 인접한 노드 중 방문하지 않는 노드를 큐에 추가한다.
    # 4 2부터 반복한다
    # 5 큐가 비면 탐색을 종료한다.


 */