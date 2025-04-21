package java_codingTest_study.section12_etc_graph;
//25 04 21 1140

import java.util.*;
public class s12_02_2667 {
    static int board[][];
    static int n;
    static int area;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    static List<Integer> arr = new ArrayList<>();

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board=new int[n][n];

        for(int i=0;i<n;i++){
            String line = sc.next();
            for(int j=0;j<n;j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }

        sol();
        System.out.println(arr.size());
        arr.sort(null);
        for(int x:arr) System.out.println(x);
    }
    private static void sol(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(board[i][j]==1){
                    area=0;
                    dfs(i, j);
                    arr.add(area);
                }

            }
        }
    }

    private static void dfs(int x,int y){
        area++;
        board[x][y]=2;

        for(int i=0;i<=3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1){
                dfs(nx, ny);
            }
        }

    }
}
