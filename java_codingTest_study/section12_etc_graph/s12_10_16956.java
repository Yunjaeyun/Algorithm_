package java_codingTest_study.section12_etc_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//25 05 01 8:15
public class s12_10_16956 {
    static char board[][];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[]=  {0,1,0,-1};

    static int r,c;

    static List<int[]> arr = new ArrayList<>();

    static boolean flag;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        board = new char[r][c];

        for(int i=0;i<r;i++){
            String s = sc.next();

            for(int j=0;j<c;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j]=='S') arr.add(new int[]{i, j});
            }
        }

        for(int[] array:arr){
            int x = array[0];
            int y = array[1];

            sol(x, y);
            if(flag) {
                System.out.println(0);
                return;
            }
        }


        System.out.println(1);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }


    }
    private static void sol(int x, int y){
        for(int i=0;i<=3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<r && 0<=ny && ny<c&& board[nx][ny]=='W') {
                flag=true;
                return;
            }

            if(0<=nx && nx<r && 0<=ny && ny<c&& board[nx][ny]=='.'){
                board[nx][ny] = 'D';
            }

        }

    }
}
