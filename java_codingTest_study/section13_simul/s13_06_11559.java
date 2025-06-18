package java_codingTest_study.section13_simul;

//250609

import java.util.*;
import java.io.*;
import java.util.List;

public class s13_06_11559 {

    static char board[][];
    static int dx[] = {-1, 0, 1, 0};//상 ->  하  <-
    static int dy[] = {0, 1, 0, -1};

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];

        for(int i=0;i<12;i++){
            String s = br.readLine();
            for(int j=0;j<6;j++){
                board[i][j] = s.charAt(j);
            }
        }

        // 돌면서 확인한다 .이 아니고, 연쇄작용이 일어날 만한가? bfs

        // 일어날 만 하다 -> 연쇄 터트리고 한칸씩 중력작용

        int chain=0;
        while(true){
            boolean popped=false;

            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(board[i][j]!='.'){

                        if(BFS_Erase(i,j)) {
                            popped=true;

                            // 중력 작용받아서 내려야하는디


                        }
                    }
                }
            }
            if(!popped) break;
            else chain++;

            fall();

        }


        System.out.println(chain);

    }
    private static boolean BFS_Erase(int i, int j){
        List<Point> group = new ArrayList<>();
        group.add(new Point(i, j));

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));

        boolean visited[][] = new boolean[12][6];
        visited[i][j]=true;

        char target = board[i][j];




        while(!q.isEmpty()){

            Point cur = q.poll();

            for(int k=0;k<=3;k++){
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(0>nx || nx>=12 || 0>ny || ny>=6) continue;

                if(target==board[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny]=true;

                    group.add(new Point(nx, ny));
                    q.offer(new Point(nx, ny));
                }

            }
        }
        if(group.size()>=4){
            for(Point idx:group){
                board[idx.x][idx.y] = '.';
            }
            return true;
        }
        return false;
    }


    private static void fall(){
        // 색깔들 모아서 담기

        // 열 싹 다 '.' 으로

        // 다시 아래서부터 차곡

        //board[i][j]
        //      행 열

        for(int j=0;j<6;j++){
            List<Character> arr = new ArrayList<>();

            for(int i=11;i>=0;i--){
                if(board[i][j]!='.')
                    arr.add(board[i][j]);
            }

            for(int i=11;i>=0;i--){
                board[i][j] = '.';
            }

            /*
            [09][0]  [09][1]
            [10][0]  [10][1]
            [11][0]  [11][1]
             */
            int row=11;
            for(char x:arr){
                board[row][j]=x;
                row--;
            }



        }


    }
}
        /*

        3 3 3
        2 * 2     3   3
        * * *  => 2   2
        2 * 2     2 3 2


         */