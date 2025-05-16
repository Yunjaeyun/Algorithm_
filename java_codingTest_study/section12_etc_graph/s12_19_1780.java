package java_codingTest_study.section12_etc_graph;
//250516

import java.util.*;
public class s12_19_1780 {

    static int board[][];

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    private static void divide(int x, int y, int size){
        if(Is_It_NXN_all_same(x,y,size)){
            int value = board[x][y];
            if (value==-1) minusOne++;
            else if(value==0) zero++;
            else if(value==1) plusOne++;
            return;
        }else{

            int reSize = size / 3;      //첫트 3

            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {

                    divide(x + reSize * dx, y + reSize * dy, reSize);

                }
            }
        }
    }
    private static boolean Is_It_NXN_all_same(int x,int y,int size){
        int target = board[x][y];
        for (int nx = x; nx < x + size; nx++) {
            for (int ny = y; ny < y + size; ny++) {
                if(board[nx][ny]!=target) return false;
            }
        }
        return true;
    }
}
/*

                                                                     return
                                                                       |
   return +1;          return return  return          r   r          d(6,0,1)
   |                    |       |         |           |    |          |
divide(0,0,3)for문   d(0,3,3)  d(0,6,3)  d(3,0,3)  d(3,3,3)d(3,6,3) d(6,0,3)
    |                    |      |          |         |       |       |           |       |
divide(0,0,9) F



1)x=0 y=0
(0 0)(0 3)(0 6) x, y+3*1 y+3*2
(3 0)(3 3)(3 6)
(6 0)(6 3)(6 6)

x+3*0 x+3*1 x+3*2


 */