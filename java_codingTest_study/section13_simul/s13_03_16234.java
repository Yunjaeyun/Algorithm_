package java_codingTest_study.section13_simul;

// 25 06 06

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class s13_03_16234 {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];

    private static class Info{
        int x, y;// num=인구수

        Info(int x, int y){
            this.x=x;
            this.y=y;
        }

    }

    static int board[][];


    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(func(n, l, r, board));
    }
    private static int func(int n, int l ,int r, int board[][]){
        /*
        라인 돌면서 국경선 공유하는 칸이 범위내에 존재(=연합예정칸)하는지 확인.bfs - *
        if 연합예정칸
            +=
            칸에 표기(as you can)

        모든칸에 다 표기했고, 전체 연합 인구수 / 칸수 = new
        칸 다 돌면서 , 표기된 칸에 new값 할당

         */


        //for bfs
        int days=0;
        while(true) {
            visited=new boolean[n][n];
            boolean moved=false;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j]) continue;

                    List<Info> unionList = bfs(i, j, l, r);


                    if(unionList.size()>1){ // 연합이 이루어진다면,
                        // 값 할당
                        moved=true;
                        int sum=0;


                        for (Info cur : unionList) sum += board[cur.x][cur.y];

                        int avg = sum / unionList.size();

                        for (Info cur : unionList) board[cur.x][cur.y] = avg;
                    }
                }
            }


            // 한바퀴 연합 다끝났는데도 불구하고.
            if(!moved) return days;
            days++;

        }

    }
    private static List<Info> bfs(int a, int b, int L, int R){
        List<Info>union = new ArrayList<>();
        union.add(new Info(a, b));

        Queue<Info> q = new ArrayDeque<>();


        q.offer(new Info(a, b));
        visited[a][b]=true;

            while(!q.isEmpty()){
                // 방문처리.
                int len = q.size();
                for(int k=0;k<len;k++){

                    Info idx = q.poll();
                    int x=idx.x;
                    int y=idx.y;

                    for(int i=0;i<=3;i++){
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if(0>nx || nx>=n || 0>ny || ny>=n) continue;
                        if(visited[nx][ny]) continue;

                        if(L<=Math.abs(board[x][y]-board[nx][ny]) && Math.abs(board[x][y]-board[nx][ny])<=R){
                            //방문처리
                            visited[nx][ny]=true;


                            union.add(new Info(nx, ny));
                            q.offer(new Info(nx, ny));
                        }

                    }
                }
            }
            return union;
        }
}
