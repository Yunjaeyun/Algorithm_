package java_codingTest_study.section12_etc_graph;

import java.util.*;
public class s12_23_17090 {

    static char board[][];
    static int memo[][];

    static int n,m;

    static boolean visited[][];

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        visited=new boolean[n][m];
        memo = new int[n][m];
        for(int [] row:memo){
            Arrays.fill(row,-1);

        }

        for(int i=0;i<n;i++){
            String s = sc.next();
            board[i] = s.toCharArray();
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){


                if( DFS(i, j)==2) cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static int DFS(int x, int y){
        if(memo[x][y]>-1) return memo[x][y];
        if(visited[x][y]) return memo[x][y]=3; // 반복- 사이클

        visited[x][y]=true;

        int nx=x,ny=y;
        switch(board[x][y]){
            case 'U': nx--;
                break;
            case 'R':ny++;
                break;
            case 'D':nx++;
                break;
            case 'L':ny--;
                break;
        }

        if(0>nx || nx>=n || 0>ny || ny>=m) return memo[x][y]=2; // 2:탈출
        else{
            int value=DFS(nx, ny);
            memo[x][y]=value;
        }

        visited[x][y]=false;
        return memo[x][y];

    }


}
