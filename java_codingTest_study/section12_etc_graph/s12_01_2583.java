package java_codingTest_study.section12_etc_graph;
//250416  7

import java.util.*;
public class s12_01_2583 {
    static int []dx = {-1, 0, 1, 0};
    static int []dy = {0,  1, 0, -1};

    static int area;

    static int map[][];

    static boolean visited[][];
    static int m,n;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[m][n];
        visited = new boolean[m][n];

        int k = sc.nextInt();

        for(int i=0;i<k;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();

            int x2=sc.nextInt();
            int y2=sc.nextInt();

            for(int y=y1;y<y2;y++){
                for(int x=x1; x<x2;x++){
                    map[y][x]=1;
                }
            }

        }

        sol(m,n);
        result.sort(null);
        System.out.println(result.size());

        for(int x:result) System.out.print(x + " ");
    }
    private static void sol(int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(map[i][j]==0 && !visited[i][j]) {
                    area = 0;
                    DFS(i, j);
                    result.add(area);
                }
            }
        }
    }

    private static void DFS(int x, int y){
        visited[x][y]=true;
        area++;

        for(int i=0;i<=3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<m && 0<=ny && ny<n){
                if(!visited[nx][ny] && map[nx][ny]!=1){
                    DFS(nx, ny);
                }
            }
        }


    }
}
