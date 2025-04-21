package java_codingTest_study.section9_graph.section9_R2;
// 25 03 20

import java.awt.*;
import java.util.*;
class Point5{
    int x,  y;
    Point5(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class s9_11_graph {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int dis[][];
    static int board[][];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        board = new int[7 + 1][7 + 1];

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                board[i][j] = sc.nextInt();
            }
        }

        dis = new int[7 + 1][7 + 1];

        BFS(1, 1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
    private static void BFS(int x, int y){
        Queue<Point5> q = new ArrayDeque<>();
        q.add(new Point5(x, y));
        board[x][y]=1;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                Point5 cur = q.poll();
                if(cur.x ==7 && cur.y==7) return;

                for(int j=0;j<=3;j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(1<=nx && nx<=7 && 1<=ny && ny<=7 && board[nx][ny]==0){
                        board[nx][ny]=1;

                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                        q.offer(new Point5(nx, ny));
                    }
                }
            }
        }

    }
}
/* bfs로 풀고,
마지막 (7,7)이 0이면 -1
새로운 dis판 만들면 될듯
 */
