package java_codingTest_study.section6_스택큐;

import java.util.Scanner;
import java.util.Stack;

// 고민되는 포인트: 격자판 구현
/*
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0

board[row][column]
board[0][1]
board[1][1]
board[2][1]
board[3][1]
board[4][1]

board[0][5]
board[1][5]
board[2][5]
board[3][5]
board[4][5]

for(){ ->fix(=moves)
    for(){ ->++(=i)
       board[++][fix]
    }
}

 */
public class s6_03_Stack_Queue {
    private int solution(int[][] board, int[] moves){
        Stack<Integer> stack=new Stack<>();
        int answer=0;
        for(int pos:moves){
            for(int i=0; i<board.length;i++){
                // 만약 해당값이 0이 아니라면 push /pop
                if(board[i][pos-1]!=0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;

                    // stack값에 있다면 pop , 없으면 push
                    if(!stack.isEmpty() && tmp==stack.peek()){
                        stack.pop();
                        answer+=2;
                        break;
                    }else{
                        stack.push(tmp);
                        break;
                    }
                }

            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][]board=new int[n][n];
        // [[ ]] 구현
        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                 board[i][j]= sc.nextInt();
            }
        }
        int m=sc.nextInt();
        int [] moves=new int[m];
        for(int i=0; i<m; i++) moves[i]=sc.nextInt();
        s6_03_Stack_Queue t=new s6_03_Stack_Queue();
        System.out.println(t.solution(board,moves));
    }
}
