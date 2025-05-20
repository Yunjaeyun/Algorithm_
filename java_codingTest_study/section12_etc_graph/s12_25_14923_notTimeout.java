package java_codingTest_study.section12_etc_graph;
import java.util.*;
//2505250

public class s12_25_14923_notTimeout {

    static int n,m,hx,hy,ex,ey;
    static int board[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static class Node{
        int x,y;
        int dist;
        int broken;

        public Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken; //0: 파괴권 미사용   1->파괴권사용
        }
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        hx = sc.nextInt()-1;
        hy = sc.nextInt()-1;

        ex = sc.nextInt()-1;
        ey = sc.nextInt()-1;

        board = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
            }
        }

        int ans = bfs(n, m, hx, hy, ex, ey, board);
        System.out.println(ans);

    }

    private static int bfs(int n,int m,int hx,int hy,int ex,int ey,int[][] board) {
        boolean [][][] visited=new boolean[n][m][2]; // 2칸 -0:미사용 1:파괴권 사용
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(hx, hy, 0, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == ex && cur.y == ey) {
                return cur.dist;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k], ny = cur.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽 만났을때
                // 벽 파괴 시도 (파괴권있음)
                if (!visited[nx][ny][1] && cur.broken == 0 && board[nx][ny] == 1) {
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1, 1)); //벽 파괴권 1회 소진한 Node로 q로 보내기
                }

                // 벽 파괴 이미 해본 분기는 no.

                // 벽이 아닐때   - 아닐때는 파괴권이 있든 말든 뭔 상관?
                if (board[nx][ny] == 0 && !visited[nx][ny][cur.broken]) {
                    visited[nx][ny][cur.broken] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1, cur.broken));
                }

            }


        }
        return -1;
    }
}
