package java_codingTest_study.section12_etc_graph;
//250503

import java.util.*;


public class s12_13_13460 {


    static char board[][];
    static boolean visited[][][][];

    static int n,m;

    static Queue<State> q = new ArrayDeque<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = { 0,1,0,-1};


    static class State{
        int rx,ry,bx,by;
        State(int rx, int ry, int bx, int by){
            this.rx=rx;
            this.ry=ry;
            this.bx=bx;
            this.by=by;
        }
    }

    static class MoveResult{
        int x,y,dist;
        boolean inhole;

        MoveResult(int x, int y, int dist, boolean inhole){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.inhole=inhole;
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        int rx=0,ry=0,bx=0,by=0;

        for(int i=0;i<n;i++){
            String s = sc.next();

            for(int j=0;j<m;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j]=='R') {
                    rx=i;
                    ry=j;
                }
                else if(board[i][j]=='B') {//두개를 동시에 굴린다. -> 한번에 몰아넣기 메서드(변수에)
                    bx=i;
                    by=j;
                }
            }

        }
        System.out.println(bfs(rx, ry, bx, by));


    }
    private static int bfs(int rx, int ry, int bx, int by){
        visited[rx][ry][bx][by]=true;
        q.add(new State(rx, ry, bx, by));
        int depth=1;


        while(!q.isEmpty()){
            int len = q.size();

            for(int k=0;k<len;k++){
                State cur = q.poll();

                if(depth>10) return -1;

                for(int i=0;i<=3;i++){
                    MoveResult red= move(cur.rx, cur.ry, dx[i], dy[i]);
                    MoveResult blue = move(cur.bx, cur.by, dx[i], dy[i]);

                    //hole문제
                    if(blue.inhole) continue;
                    if(red.inhole) return depth;

                    //벽문제(move메서드에서 hole에 in하지 않는한, 둘다 벽에 닿을때까지 가서 , 겹쳐버림)
                    if(red.x == blue.x && red.y == blue.y){
                        if(red.dist> blue.dist){
                            red.x -= dx[i];
                            red.y -= dy[i];
                        }else{
                            blue.x -= dx[i];
                            blue.y -= dy[i];
                        }
                    }


                    if(!visited[red.x][red.y][blue.x][blue.y]){
                        visited[red.x][red.y][blue.x][blue.y]=true;
                        q.offer(new State(red.x, red.y, blue.x, blue.y));
                    }
                }


            }
            depth++;
        }
        return -1;
    }

    private static MoveResult move(int x, int y, int dx, int dy){ //해당 방향으로 벽 끝까지 이동
        boolean inhole=false;
        int dist=0;

        while(board[x+dx][y+dy]!='#'){
            x+=dx;
            y+=dy;
            dist++;

            if(board[x][y]=='O'){
                inhole=true;
                break;
            }
        }
        return new MoveResult(x,y,dist,inhole);
    }
}
