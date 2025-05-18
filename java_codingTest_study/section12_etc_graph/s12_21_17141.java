package java_codingTest_study.section12_etc_graph;
//250518

import java.util.*;
public class s12_21_17141 {

    static int[][]board;
    static List<Info> virus_candidate = new ArrayList<>();

    static int n, m;

    static int[] cm;
    static Queue<Info> q;

    static boolean visited[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int [][]dis;
    static int answer = Integer.MAX_VALUE;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];
        cm = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==2) virus_candidate.add(new Info(i, j));
            }
        }

        combination_DFS(0,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
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
    }
    private static void combination_DFS(int L, int s){
        if(L==m){
//            System.out.println(Arrays.toString(cm)); // 0 1 2
            int[][] temp = deepCopy(board);

            visited = new boolean[n][n];
            q = new ArrayDeque<>();
            for(int idx:cm){
                Info cur = virus_candidate.get(idx); // (1,2)
                q.add(new Info(cur.x, cur.y));
                visited[cur.x][cur.y]=true;

                temp[cur.x][cur.y] = 2;
            }

            dis= new int[n][n];

            bfs(temp);
//            bfs(board);

            boolean allSpread=true; // 바이러스 감염 안된 칸이 하나라도 있으면 -1 OR 모두 감염시 시간 get
            int localMax=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(temp[i][j]!=1  ){
                        if(temp[i][j]==0){
                            allSpread=false;
                        }else{
                            localMax = Math.max(localMax, dis[i][j]);
                        }
                    }

                }
            }

            if(allSpread){
                answer = Math.min(answer, localMax);
            }

//            printGrid(temp);




        }else{
            for(int i = s; i< virus_candidate.size(); i++){
                cm[L] = i;
                combination_DFS(L + 1, i + 1);
            }
        }

    }
    private static void bfs(int[][] temp){
        while(!q.isEmpty()){
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            visited[x][y]=true;

            for(int i=0;i<=3;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<n){
                    if(!visited[nx][ny] && temp[nx][ny]!=1){


                        visited[nx][ny]=true;
                        dis[nx][ny] = dis[x][y] + 1;

                        temp[nx][ny]=2;
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

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==2) map[i][j]=0;
            }
        }
        return map;
    }
}
