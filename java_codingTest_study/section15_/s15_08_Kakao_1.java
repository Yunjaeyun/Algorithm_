package java_codingTest_study.section15_;
//25 07 11

import java.util.*;
public class s15_08_Kakao_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) moves[i] = sc.nextInt();

        System.out.println(sol(board, moves));
    }

    private static int sol(int[][] board, int[] moves){
        Stack<Integer> stack = new Stack<>();
        int row=board.length;
        int col=board[0].length;

        int cnt=0;

        for(int x:moves){
            for(int i=0;i<row;i++){
                // 원래있던 자리는 0으로 비우고
                // stack에 추가

                if(board[i][x-1]!=0){
                    int temp=board[i][x-1];
                    board[i][x-1]=0;



                    if(!stack.isEmpty() && stack.peek()==temp){
                        cnt+=2;
                        int t=stack.pop();


                    }else stack.push(temp);

                    break;

                }



            }


        }

        return cnt;
    }

}
