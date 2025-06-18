package java_codingTest_study.section13_simul;
//250608

import java.util.*;
import java.io.*;

public class s13_05_17144 {

    static int board[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int top=0;
    static int bot=0;
    static boolean next=false;


    public static void main(String[]args) throws Exception{
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        board = new int[r][c];

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==-1 && !next) {
                    top=i;
                    next=true;
                }
                else if(board[i][j]==-1 && next) bot= i;
            }
        }

        for(int minute=1;minute<=t;minute++) {
            spreadDirt(r, c);
            clean(r,c);
        }
        int sum=0;
        for(int[]row:board){
            for(int x:row){
                if(x>0) sum += x;
            }
        }
        System.out.println(sum);


    }

    private static void spreadDirt(int r, int c) {
        // 원본이 훼손되면  / 5 할때 문제생김
        int temp[][] = new int[r][c];
        // 미세먼지 확산
        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++){

                if(board[i][j]>=5){
                    int spread=board[i][j] /5;
                    int count=0;

                    // 4방향 중 가능한 방향으로 spread+
                    // 본인은 -

                    for(int k=0;k<=3;k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(0<=nx && nx< r && 0<=ny && ny< c && board[nx][ny]!=-1){
                            temp[nx][ny]+=spread;
                            count++;
                        }

                    }
                    //4바퀴 다 돌면 -> 본인은 - 마이너스 처리
                    temp[i][j] -= (spread * count);
                }

            }
        }

        //temp 를 board에 옮기기
        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++){
                board[i][j] += temp[i][j];
            }
        }
    }

    private static void clean(int r, int c){

        //공기청정기 - 옮기기
        // 행[]- 열[] |


        // 위쪽 구역 - 반시계방향
            //  ↓
            //  ←
            //  ↑
            //  →

        for(int i=top-1;i>0;i--){
            board[i][0]=board[i-1][0];
        }

        for(int i=0;i<c-1;i++){
            board[0][i] = board[0][i + 1];
        }

        for(int i=0;i<top;i++){
            board[i][c-1]=board[i+1][c-1];
        }

        for(int i=c-1;i>1;i--){
            board[top][i]=board[top][i-1];
        }
        //청소
        board[top][1]=0;



        // 아래쪽 구역 - 시계방향
            //  ↑
            //  ←
            //  ↓
            //  →
        for(int i=bot+1;i<r-1;i++){
            board[i][0]=board[i+1][0];
        }
        for(int i=0;i<c-1;i++){
            board[r-1][i]=board[r-1][i+1];
        }
        for(int i=r-1;i>bot;i--){
            board[i][c-1]=board[i-1][c-1];
        }
        for(int i=c-1;i>1;i--){
            board[bot][i]=board[bot][i-1];
        }


        //청소
        board[bot][1]=0;



    }



}
