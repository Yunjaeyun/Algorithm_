package java_codingTest_study.section6_스택큐.section6_R2;

import java.util.Scanner;
import java.util.Stack;

// 25 04 14
public class s6_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) moves[i] = sc.nextInt();


        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int x : moves) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][x - 1] != 0) {
                    tmp = board[i][x - 1];
                    board[i][x - 1] = 0;

                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        cnt += 2;
                        stack.pop();

                    } else stack.push(tmp);
                    break;
                }
            }


        }
        System.out.println(cnt);

    }
}
