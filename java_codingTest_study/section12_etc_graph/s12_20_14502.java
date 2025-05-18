package java_codingTest_study.section12_etc_graph;
//250517

import java.util.*;
public class s12_20_14502 {

    static int[][]board;
    static List<Info> arr = new ArrayList<>();
    static List<Info> virus = new ArrayList<>();

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] cm = new int[3];
    static int[] ch ;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int n,m;
    static boolean visited[][];

    static int answer=0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==0) arr.add(new Info(i, j));
                else if(board[i][j]==2) virus.add(new Info(i, j));
            }
        }


        ch = new int[arr.size()];

        combination(0,0);
        System.out.println(answer);
    }



    private static void combination(int L, int s){
        int safeZone=0;

        if(L==3){
            System.out.println(Arrays.toString(cm)); // 0 1 2

            for(int idx:cm){

                Info cur = arr.get(idx);

                board[cur.x][cur.y]=1;
            }

            // 방문배열 초기화
            visited = new boolean[n][m];

            int[][] temp = deepCopy(board);
            for(Info cur:virus){ // (1,2) (2,3)
                dfs_spred_virus(temp ,cur.x, cur.y);
            }

            for(int x=0;x<n;x++){
                for(int y=0;y<m;y++){
                    if(temp[x][y]==0) safeZone++;
                }
            }
            answer = Math.max(answer, safeZone);

            // 시뮬레이션 후
            for(int idx : cm) {
                Info cur = arr.get(idx);
                board[cur.x][cur.y] = 0;
            }



        }else{
            for(int i=s;i<arr.size();i++){
                    cm[L] = i;
                    combination(L + 1, i+1);

                }
        }
    }

    private static void dfs_spred_virus(int[][]temp, int x, int y ){
        visited[x][y]=true;
        for(int i=0;i<=3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<n && 0<=ny && ny<m) {
                if(!visited[nx][ny] && temp[nx][ny]==0){
                    visited[nx][ny]=true;

                    temp[nx][ny]=2;
                    dfs_spred_virus(temp,nx, ny);
                }
            }


        }
    }

    private static int[][] deepCopy(int[][] board){
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            map[i] = board[i].clone();
        }
        return map;
    }
}
/*
3 6 9

3 6
3 9
6 9

                d(0,1)
           / 1  |2 |3|4 |5 |6  |7  |8  |9  |10  |11  |12  ...n      \
        d(1,2)
        /
      d(2,3)
      /3  |4
   d(3)   re
  123     124


d(0,1) for
 */