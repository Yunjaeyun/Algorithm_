package java_codingTest_study.section12_etc_graph;
//250523

import java.util.*;


public class s12_27_4991 {

    static char [][]board;
    static int w,h;
    static Set<String> cleaned;
    static Queue<State> q;
    static Set<String> visited; //visit에는 내가 현재 어디를 청소했는지가 기록되어야함. (1,1),(2,3)청소완료 등..

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    private static class State{
        int x, y;
        Set<String> cleaned;
        int dist;

        public State(int x, int y, Set<String> cleaned, int dist) {
            this.x = x;
            this.y = y;
            this.cleaned = cleaned;
            this.dist = dist;
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            if(w==0 && h==0) break;

            board = new char[h][w];
            q = new ArrayDeque<>();
            visited = new HashSet<>();
            int totalTrashCount=0;

            for(int i=0;i<h;i++){
                String s = sc.next();
                for(int j=0;j<s.length();j++){
                    board[i][j] = s.charAt(j);
                    if(board[i][j]=='o') q.offer(new State(i, j, new HashSet<>(), 0));
                    else if(board[i][j]=='*') totalTrashCount++;

                }
            }

            BFS(board);
        }
    }

    private static void BFS(char[][] board){

        while(!q.isEmpty()){
            int len = q.size();
            for(int k=0;k<len;k++){
                State cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                int dist = cur.dist;

                //청소기 돌면서

                //쓰레기 발견시 +1, visited처리
                for(int i=0;i<=3;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(0>nx || h>nx || 0>ny || w>ny) continue;
                    if(board[nx][ny]=='x') continue;

                    // *방문시 현재위치 key로 만듬
                    // visited과 비교
                    // 첫방문이라면 visited에 추가
                    String key = nx + "," + ny; // "1,3"

                    if(board[nx][ny]=='*'){
                    }

                    if(!cur.cleaned.contains(key)){

                    }





                }
            }
        }



    }
}
/*
신규쓰레기라면
쓰레기완료통에 넣어.


이미 청소된 거라면 안 넣지.

string 비교는
Set<String> a = ["1,5", "3,1", "3,5"]
Set<String> b = ["3,5", "1,5", "3,1"]


1.모든값이 넣어진 상태에서 비교해야함

String keyA = "x,y|1,5;3,1;3,5"
String keyB = "x,y|3,5;1,5;3,1"   -> 2.이렇게하면 안됨. 정렬되어야지

                         ____
String keyA = "1,5"          |<== 그래서 이렇게 하면 안됨. 다 일단 넣고봐야됨.
String keyB = "3,1, 3,5"     |
                         -----


                         // *방문시 현재위치 key로 만듬
                         // visited과 비교
                         // 첫방문이라면 visited에 추가
 */