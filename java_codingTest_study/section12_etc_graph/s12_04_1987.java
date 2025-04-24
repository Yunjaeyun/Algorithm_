package java_codingTest_study.section12_etc_graph;
//25 04 23

import java.util.*;
public class s12_04_1987 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static char[][] board;

    static int area=0;
    static int r,c;
    static int answer = Integer.MIN_VALUE;

    static List<Character> arr=new ArrayList<>();
    static boolean alpha[] = new boolean[26];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         r = sc.nextInt();
         c = sc.nextInt();

        board=new char[r][c];

        for(int i=0;i<r;i++){
            String line = sc.next();

            for(int j=0;j<c;j++){
                board[i][j] = line.charAt(j);
            }
        }

        alpha[board[0][0]-'A']=true;
        dfs(0, 0,1);
        System.out.println(answer);

    }
    private static void dfs(int x,int y, int count){
        answer = Math.max(answer, count);

        for(int i=0;i<=3;i++){
            int nx = x +dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<r && 0<=ny && ny<c ){
                char next = board[nx][ny];
                if(!alpha[next-'A']){
                    alpha[next-'A']=true;
                    dfs(nx, ny, count+1);
                    alpha[next-'A']=false;

                }

            }
        }


    }
}
/*

d(1,0) 1234 return
d(2,0) 1
d(2,1) 1234
d(1,1) 123
d(0,1) 3

d([0][2]) 1234 return
d(0,1) 12
d(0,0) 12

 */