package java_codingTest_study.section9_graph.section9_R1;
//25 03 09

import java.util.*;
public class s9_13_graph {
    static int[][]board;
    static int[] dx = {-1,-1 ,0,1 ,1,1   ,0,-1 };
    static int[] dy = {0, 1  ,1,1 ,0,-1 ,-1,-1 };

    static int n;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        int answer=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    DFS(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int x,int y){

        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<= nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1){
                board[nx][ny]=0;
                DFS(nx, ny);
            }
        }
    }
}
/*
dfs로 푼다. 격자판을 다돈다.
1.탈출조건을 무엇으로 할것인가.
2.섬 한개의 존재를 어떻게 체크할것인가.
3. 더이상 돌수없을때의 if문 탈출조건 return을 어떻게 처리할까 dfs내에서의. -> 정답확인결과: dfs는 반드시 if문을 써야된다!는 아니구나.
 문제 구조상 갈수있는곳과 갈수없는곳이 떨어져있기때문에 , 더이상 돌지못하면 알아서 return될테니까

모든 격자판을 돌면서 dfs호출하면 될듯한데..라는 생각까진 했음.
 */