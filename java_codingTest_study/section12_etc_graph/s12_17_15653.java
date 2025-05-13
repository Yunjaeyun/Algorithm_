package java_codingTest_study.section12_etc_graph;
//25 05 10 655

import java.util.*;

public class s12_17_15653 {

    static char board[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0, 1, 0, -1};

    static boolean visited[][][][];




    private static class State{
        int bx,by,rx,ry ,cnt;

        public State(int bx, int by, int rx, int ry, int cnt) {
            this.bx = bx;
            this.by = by;
            this.rx = rx;
            this.ry = ry;
            this.cnt=cnt;
        }
    }



    private static class MoveResult {
        int x,y,dist;
        boolean inhole;

        public MoveResult(int x, int y,boolean inhole,int dist) {
            this.x = x;
            this.y = y;
            this.inhole = inhole;
            this.dist = dist;
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        int bx=0,by=0,rx=0,ry=0, cnt=0;

        for(int i=0;i<n;i++){
            String s = sc.next();

            for(int j=0;j<m;j++){
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                } // Blue와 Red의 좌표를 저장해서 넘겨야하는데, 마땅히할데가없네 -> 제3의 변수 만들어서 넘기자
                else if (board[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }
            }
        }

        bfs(bx,by,rx,ry, cnt);
    }

    private static void bfs(int bx,int by, int rx, int ry, int cnt){
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(bx, by, rx, ry,cnt));

        visited[bx][by][rx][ry]=true;

        while(!q.isEmpty()){
            State cur = q.poll();

            for(int i=0;i<=3;i++){
                MoveResult blue = move(cur.bx, cur.by, dx[i], dy[i]);
                MoveResult red = move(cur.rx, cur.ry, dx[i], dy[i]);

                if(blue.inhole) continue;
                if(red.inhole) {
                    System.out.println(cur.cnt+1);
                    return;
                }

                if(blue.x==red.x && blue.y==red.y){ //기울여짐에 의해 두공이 같은 위치에 놓였음. 이동거리계산해서 재정렬
                    if(blue.dist > red.dist){ //blue이 더 많이  구른거임. red공보다 뒤에 있었던거지.
                        blue.x -= dx[i];
                        blue.y -= dy[i];

                    }else if(red.dist> blue.dist){
                        red.x -= dx[i];
                        red.y -= dy[i];


                    }
                }

                if(!visited[blue.x][blue.y][red.x][red.y]){
                    visited[blue.x][blue.y][red.x][red.y]=true;
                    q.offer(new State(blue.x, blue.y, red.x, red.y, cur.cnt + 1));
                }



            }
        }
        System.out.println(-1);
    }

    private static MoveResult move(int x, int y, int dx, int dy){
        boolean inhole=false;
        int dist=0;

        while(board[x+dx][y+dy]!='#'){
            x+=dx;
            y+=dy;

            dist++;

            if(board[x][y]=='O'){
                inhole=true;
                return new MoveResult(x,y,inhole, dist);
            }
        }
        return new MoveResult(x,y,inhole, dist);
    }
}
