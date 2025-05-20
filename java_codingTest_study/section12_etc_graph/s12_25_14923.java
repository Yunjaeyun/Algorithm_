package java_codingTest_study.section12_etc_graph;
//2505250

import java.util.*;
public class s12_25_14923 {

    static int n,m,hx,hy,ex,ey;
    static int board[][];

    static List<Info> wall_Change_candidate = new ArrayList<>();
    static int[] ch = new int[1];
    static Queue<Info> q ;
    static boolean [][] visited;

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static boolean escape;

    static int answer_dist;
    static int answer=Integer.MAX_VALUE;


    private static class Info{
        int x, y, dist;
        Info(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    public static void main(String[]args){
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
                if(board[i][j]==1) wall_Change_candidate.add(new Info(i, j,0));
            }
        }

        // combi로 벽 위치 다 긁어 와서,1번만 변경가능 하니까
        // 변경하고 검사하고, 다시 원복

        combination_DFS(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    private static void combination_DFS(int L, int s){
        if(L==1){

            int idx = ch[0];
            Info cur = wall_Change_candidate.get(idx);

            int Changex = cur.x;
            int Changey = cur.y;

            board[Changex][Changey]=0;

            escape=false;
            answer_dist=0;

            q = new ArrayDeque<>();
            q.add(new Info(hx, hy,0));

            visited=new boolean[n][m];

            visited[hx][hy]=true;
            BFS(ex,ey,0);


            board[Changex][Changey]=1; //원복

            System.out.println(answer_dist);
            if(escape){
                answer = Math.min(answer, answer_dist);
            }

        }else{
            for(int i=s;i<wall_Change_candidate.size();i++){
                ch[L] = i;
                combination_DFS(L + 1, i + 1);
            }
        }
    }
    private static void BFS(int ex, int ey, int dist){
        while(!q.isEmpty()){
            int len = q.size();

            for(int k=0;k<len;k++){

                Info cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                for(int i=0;i<=3;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(0>nx || nx>=n || 0>ny || ny>=m) continue;

                    if(!visited[nx][ny] && board[nx][ny]!=1){
                        //큐 visit board

                        if(nx==ex && ny==ey){
                            escape=true;
                            answer_dist = cur.dist + 1;
                            return;
                        }

                        visited[nx][ny]=true;
                        q.offer(new Info(nx, ny, cur.dist+1));


                    }
                }


            }

        }
    }
}
