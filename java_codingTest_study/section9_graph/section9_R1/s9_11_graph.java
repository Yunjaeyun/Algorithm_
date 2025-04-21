package java_codingTest_study.section9_graph.section9_R1;
//25 03 07
import java.util.*;

class Point1{
    int x, y;
    Point1(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class s9_11_graph {
    static int [][]graph;
    static int[][] dis;

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        graph = new int[7 + 1][7 + 1];
        dis = new int[7 + 1][7 + 1];

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        BFS(1,1);

        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
    private static void BFS(int x, int y){
        Queue<Point1> q = new ArrayDeque<>();
        q.offer(new Point1(1, 1));
        graph[x][y]=1;

        while(!q.isEmpty()){
            Point1 cur = q.poll(); // (0,0)

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if( 1<=nx && nx<=7 && 1<=ny && ny<=7 && graph[nx][ny]==0 ){
                    graph[nx][ny]=1;
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;

                    q.offer(new Point1(nx, ny));
                }
            }
        }

    }
}
