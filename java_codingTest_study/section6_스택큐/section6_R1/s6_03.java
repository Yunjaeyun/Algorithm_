package java_codingTest_study.section6_스택큐.section6_R1;
//25 04 02

import java.util.*;
public class s6_03 {
    static int[][]board;
    static int []moves;
    static int n,m;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }
         m = sc.nextInt();
        moves = new int[m];

        for (int i = 0; i < m; i++) moves[i] = sc.nextInt();

        System.out.println(sol(board, moves));

    }

    private static int sol(int[][]board, int[]moves){
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(int pos:moves){
            for(int i=0;i<n;i++){
                if(board[i][pos-1]!=0){
                    int board_peek = board[i][pos - 1];
                    board[i][pos-1]=0;


                    if(!stack.isEmpty()  && board_peek == stack.peek()) {
                        stack.pop();
                        answer+=2;

                    }else stack.push(board_peek);
                    break;
                }
            }
        }
        return answer;
    }
}
