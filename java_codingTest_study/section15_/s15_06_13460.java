package java_codingTest_study.section15_;
//25 07 06
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s15_06_13460 {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static boolean visited[][][][];

    private static class Info{
        int x, y, dist;
        boolean inhole;

        public Info(int x, int y, int dist, boolean inhole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inhole = inhole;
        }
    }

    private static class State{
        int rx,ry,bx,by;

        public State(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m][n][m];

        int red_x=0, red_y=0, blue_x=0, blue_y=0;

        char [][]board = new char[n][m];
        for(int i=0;i<n;i++){
           String s=(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j]=='B') {
                    blue_x = i;
                    blue_y = j;
                    board[i][j] = '.';

                }else if(board[i][j]=='R'){
                    red_x =i;
                    red_y =j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(sol(board,red_x, red_y, blue_x, blue_y));
    }
//    이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다.
//    왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
//
//    각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다.
//    빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다.
//    또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.


    public static int sol(char [][] board, int rx, int ry, int bx, int by){
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry,bx, by));
        visited[rx][ry][bx][by]=true;

        int depth=0;


        while(!q.isEmpty()){

            int len = q.size();
            for(int j=0;j<len;j++){


                if(depth==10) return -1;

                State cur = q.poll();
                int r_x=cur.rx;
                int r_y=cur.ry;

                int b_x=cur.bx;
                int b_y=cur.by;

                //    이때, red blue 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다.
//    왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
                for(int i=0;i<4;i++){



                    Info red=tilt(board,r_x,r_y, i);
                    Info blue=tilt(board,b_x,b_y,i);


                    // 같은 라인에 있다면, tilt Moving 이후, 원래 뒤에있던 공을 한칸은 뒤로 가게두어야함.
//            if(redResult.x==blueResult.x){
//                if(redResult.y-blueResult.y<0){
//
//                }
//            }else if(redResult.y==blueResult.y){
//
//            } ->위치 vs의 기준으로 하면 너무 복잡한것같음. ★이동한거리 vs의 기준

                    if(blue.inhole) continue;
                    if(red.inhole && !blue.inhole) return depth+1;

                    if(red.x ==blue.x && red.y== blue.y ){

                        if(red.dist>blue.dist){
                            // red 공 한칸뒤로 (1,4)
                            red.x -= dx[i];
                            red.y -= dy[i];
                        }else if(blue.dist>red.dist){
                            // blue 공 한칸뒤로 (1,5)(1,1)(1,2)
                            //
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

    public static  Info tilt(char [][] board, int x,int y, int dir){
        // 한쪽방향으로 두개의 공이 쏠림
        // 겹치면 안됨. 그부분도 추가 구현

        // 왼쪽으로 기울이는데, 빨강공(1,4)이 앞선다. 파란공(1,5)
        // ★ 공이 이동하다가 빠져버리는 경우

        int dist=0;
        boolean inhole=false;

        while(true){

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(board[nx][ny]=='#') break;

            x=nx;
            y=ny;
            dist++;

            if(board[x][y]=='O'){
                inhole=true;
                break;
            }
        }


        return new Info(x,y, dist, inhole);
    }
}
