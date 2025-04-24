package java_codingTest_study.section12_etc_graph;
//25 04 23

import java.util.*;
import java.util.List;
class Point{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class s12_04_2580 {
    static int[][] board;
    static List<Point> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 0) {
                    arr.add(new Point(i, j)); // 빈칸 좌표 저장
                }
            }
        }

        dfs(0); // 첫 번째 빈칸부터 시작
    }

    static void dfs(int depth) {
        if(depth==arr.size()){
            printBoard();
            System.exit(0);
        }

        Point cur = arr.get(depth);
        int x = cur.x;
        int y = cur.y;

        for(int num=1;num<=9;num++){
            if(isValid(x,y,num)){
                board[x][y] = num;
                dfs(depth + 1);
                board[x][y] = 0;
            }
        }
    }

    static boolean isValid(int x, int y, int num) {
        for(int i=0;i<9;i++){
            if(board[x][i]==num) return false;
        }

        for(int i=0;i<9;i++){
            if(board[i][y]==num) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for(int i=startX;i<startX+3;i++){
            for(int j=startY; j<startY+3;j++){
                if(board[i][j]==num) return false;
            }
        }

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}