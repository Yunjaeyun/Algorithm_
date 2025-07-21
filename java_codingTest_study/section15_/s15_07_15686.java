package java_codingTest_study.section15_;
//25 07 09

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s15_07_15686 {

    private static class Info {
        int x,y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int board[][];
    static int m;
    static int cm[];

    static List<Info> home = new ArrayList<>();
    static List<Info> chicken = new ArrayList<>();


    public static void main(String[]args) throws Exception{
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(sb.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        cm = new int[m];



        for(int i=0;i<n;i++){
            st = new StringTokenizer(sb.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1) home.add(new Info(i, j));
                else if(board[i][j]==2) chicken.add(new Info(i, j));
            }
        }

        sol();
    }

    private static void sol() {
        // 치킨집 폐업시키기 nCr
        int n=chicken.size();

        combination_DFS(0,0,n);
        System.out.println(re);


    }
    static int re=Integer.MAX_VALUE;

    private static void combination_DFS(int L, int s,int n){ //*

        if(L==m){
//            System.out.println(Arrays.toString(cm));

            int total=0;


            for(Info ho:home){ //
                int result=Integer.MAX_VALUE;

//                System.out.println("home좌표: " + ho.x + " " + ho.y);
                for(int x:cm){
                    Info ch = chicken.get(x);

                    int cal = Math.abs(ch.x - ho.x) + Math.abs(ch.y - ho.y);
                    result = Math.min(result, cal);
//                    System.out.println("중간 result:"+ result);
                }
                total+=result;
//                System.out.println("total_answer:" + total);
            }
            re = Math.min(total, re);


        }else {
            for(int i=s;i<n;i++){
                cm[L]=i;
                combination_DFS(L + 1,i+1,n );
            }
        }
    }
}
