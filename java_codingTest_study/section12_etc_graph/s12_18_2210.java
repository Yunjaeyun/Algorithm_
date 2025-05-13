package java_codingTest_study.section12_etc_graph;
//25 05 12

import java.util.*;
public class s12_18_2210 {

    static int[][]board;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int[]ch;

    static Set<String> set = new HashSet<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[]args){
        int n=5;
        Scanner sc = new Scanner(System.in);

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ch = new int[6];
                DFS(0,i,j);

            }
        }
        System.out.println(set.size());

    }

    private static void DFS(int L, int i, int j){
        if(L==6){

            sb.setLength(0);

            for(int x:ch){
                sb.append(x);
            }

            set.add(sb.toString());


        }else{

            ch[L]=board[i][j];

            for(int k=0;k<=3;k++){
                int nx = i + dx[k];
                int ny = j + dy[k];


                if(0<=nx && nx<5 && 0<=ny && ny<5){
                    DFS(L + 1, nx,ny);
                }
            }
        }
    }
}
// 각자의 모든 자릿수를 거쳐서 Level 6까지 감
// 가능한 모든수 중에서 중복을 제거.

/*
       d(1,)
       /동|   서  |남    \북
     d(2,) d(2, ) d(2, ) d(2, )
   /...
   d3
   d4
   d5
   d6





 */