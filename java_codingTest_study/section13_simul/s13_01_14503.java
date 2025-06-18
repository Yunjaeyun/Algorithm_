package java_codingTest_study.section13_simul;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class s13_01_14503 {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int board[][];
    static int n,m;

    static int cleanCount;

    private static class Info{
        int x,y,dir;

        public Info(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m]; //0 빈칸 1 벽

        int x = sc.nextInt() ;
        int y = sc.nextInt() ;
        int dir = sc.nextInt(); // 방향



        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
            }
        }

        func(x, y, dir);
        System.out.println(cleanCount);

    }
    private static void func(int startx, int starty, int startdir){
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(startx, starty, startdir));

        board[startx][starty]=2;
        cleanCount=1;


        while(!q.isEmpty()){
            int len = q.size();

            for(int k=0;k<len;k++){

                Info cur = q.poll();
                int x=cur.x;
                int y=cur.y;
                int dir=cur.dir;

                int temp_dir=dir;

                boolean needto_Goback=true;

                for(int i=0;i<=3;i++) {
                    temp_dir = turn(temp_dir);

                    int nx = x + dx[temp_dir];
                    int ny = y + dy[temp_dir];

                    // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                        cleanCount++;
                        q.offer(new Info(nx, ny, temp_dir));
                        needto_Goback = false;
                        break;
                    }
                }

                    // 다 청소된 경우 후진
                if(needto_Goback){
                    int backdir = go_back(dir);
                    int backX=x+dx[backdir];
                    int backY=y+dy[backdir];

                    if(board[backX][backY]==1) return;

                    q.offer(new Info(backX, backY, dir));
                }
            }
        }
    }
    private static int turn(int dir){
        return (dir + 3) % 4;
    }

    private static int go_back(int dir){
        return (dir + 2) % 4;
    }

}
/*

    0북
3서      1동
    2남

    북  동  남  서
     0  1   2  3
 x {-1  0, +1  0 }
 y {0   +1 ,0  -1 }
0

북 -> 서 (반시계방향으로 회전)
 0    3

서 -> 남 (반시계방향으로 회전)
3     2

 (dir +3) %4


(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

<후진>
후진은 지금 방향에 따라 달라짐
             후진
0->2
1->3

return (d+2)%4
 */