package java_codingTest_study.section12_etc_graph;
//250521

import java.util.*;
public class s12_26_1726 {

    static int m,n;
    static int[][]board;
    static boolean [][][]visited;

    // 동 남 서 북
    static int[] dx = { 0, 1, 0, -1};
    static int[] dy = { 1, 0, -1, 0};

    static int fx,fy,fdir;

    static Queue<Info> q=new ArrayDeque<>();



    private static class Info{
        int x,y, dir;
        int dist;

        public Info(int x, int y, int dir, int dist) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }
    }

    static int mapDir(int d){
        switch(d){
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
        }
        return -1;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        visited = new boolean[m][n][4]; //방향정보1234 추가 - 같은 위치라도 동서남북 다 돌수있잖슴. 이차원배열 x

        board = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        // 현재 향하는 방향을 bfs의 info에 담아야할듯
        // 주의: 좌표의 특성반영 -1
        // sx startX sy startY
        // dir 동1 서2 남3 북4
        int sx = sc.nextInt()-1;
        int sy = sc.nextInt()-1;
        int sdir = mapDir(sc.nextInt());

        //final x final y
        fx = sc.nextInt() - 1;
        fy = sc.nextInt() - 1;
        fdir = mapDir(sc.nextInt());


        q.offer(new Info(sx, sy, sdir, 0));
        visited[sx][sy][sdir]=true;

        BFS(sx,sy,sdir);
    }
    private static void BFS(int a, int b, int direction){

        while(!q.isEmpty()){
            int len = q.size();

            for(int p=0;p<len;p++){
                Info cur = q.poll();

                int x = cur.x;
                int y = cur.y;
                int dir = cur.dir; //3 남 방향(x++)
                int dist = cur.dist;

                if(x==fx && y==fy && dir==fdir){
                    System.out.println(dist);
                    return;
                }



                //지금 방향으로 go 1 , 2, 3
                for(int k=1;k<=3;k++){ //k
                    int nx=x+(dx[dir]*k);
                    int ny=y+(dy[dir]*k);

                    if(0>nx || nx>=m || 0>ny || ny>=n) break;

                    //벽
                    if(board[nx][ny]==1) break;

                    if(!visited[nx][ny][dir]) {
                        visited[nx][ny][dir]=true;
                        q.offer(new Info(nx, ny, dir, dist + 1));
                    }

                }

                //TURN
                // turn -left
                int rightDir = (dir + 1) % 4;
                if(!visited[x][y][rightDir]){
                    visited[x][y][rightDir]=true;
                    q.offer(new Info(x,y,rightDir,dist+1));

                }

                // turn -right
                int leftDir = (dir + 3) % 4;
                if(!visited[x][y][leftDir]){
                    visited[x][y][leftDir]=true;
                    q.offer(new Info(x,y,leftDir,dist+1));
                }



            }
        }


    }
}
/*
  want            provided
    북3               북4
서2     동0   <-  서2      동1
    남1               남3

동->남->서->북


turn right : 북0 -> 동1 (dir+1 )%4
turn left  : 북0 -> 서3 (dir+3 )%4

문제기준 동1 서2 남3 북4
내  기준 동0 서2 남1 북3

 */
