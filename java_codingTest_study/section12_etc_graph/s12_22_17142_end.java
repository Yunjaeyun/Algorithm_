package java_codingTest_study.section12_etc_graph;
//250519

import java.util.*;

public class s12_22_17142_end {

    static int[][]board;

    static List<Info> candidate = new ArrayList<>();

    static int n,m;
    static int cm[];

    static Queue<Info> q;
    static boolean visited[][];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int[][]dis;

    static int answer = Integer.MAX_VALUE;

    static class Info{
        int x,y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        cm = new int[m];
        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==2) candidate.add(new Info(i, j));
            }
        }

        combination_DFS(0,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);


    }

    private static void combination_DFS(int L, int s){
        if(L==m){

//            System.out.println(Arrays.toString(cm));



            int[][] temp = deepCopy(board);


            dis = new int[n][n];
            visited = new boolean[n][n];
            q = new ArrayDeque<>();

            for(int idx:cm){

                Info cur = candidate.get(idx);

                temp[cur.x][cur.y]=2;
                visited[cur.x][cur.y]=true;

                q.offer(new Info(cur.x, cur.y));

            }
            BFS(temp);


            int midterm=0;
            boolean allSpread=true;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(temp[i][j]==1) continue;

                    //  퍼지지 않은 0,2가 있으면 실패
                        if(!visited[i][j]){
                            allSpread=false;
                            break;
                        }
                        //시간 측정
                        else if(board[i][j]==0){
                            midterm = Math.max(midterm, dis[i][j]);
                        }

                }
                if(!allSpread) break;
            }


            if(allSpread){
                answer = Math.min(answer, midterm);
            }

//            System.out.println("temp");
//            printGrid(temp);
//
//            System.out.println("dis");
//            printGrid(dis);


        }else{
            for(int i=s;i<candidate.size();i++){
                cm[L] = i;
                combination_DFS(L + 1, i + 1);
            }
        }
    }

    private static void BFS(int[][] temp){
        while(!q.isEmpty()){
            Info cur = q.poll();
            int x=cur.x;
            int y=cur.y;

            for(int i=0;i<=3;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<n){
                    if(!visited[nx][ny] && temp[nx][ny]!=1){
                        visited[nx][ny]=true;

                        if(temp[nx][ny]==0) {// 비활성->활성 말고, 문제는 원래 활성된 애들만 계산원함. 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제
                            dis[nx][ny]=dis[x][y]+1;}
                        temp[nx][ny]=2;

                        if(dis[x][y]+1 >=answer && answer!=Integer.MAX_VALUE)
                            return;

                        q.offer(new Info(nx, ny));



                    }
                }
            }


        }
    }
    private static int[][] deepCopy(int[][] src){
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = src[i].clone();
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(map[i][j]==2) map[i][j]=0;
//            }
//        }
        return map;
    }
    public static void printGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 각 칸 사이에 공백 한 칸
                System.out.print(grid[i][j] + " ");
            }
            // 한 행을 다 출력했으면 줄바꿈
            System.out.println();
        }
        System.out.println();

    }
}
