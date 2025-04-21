package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_08_graph {
    static int dx[] = {1, -1, 5};
    static int[]ch;
    static int L =0;
    static int e;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        e = sc.nextInt();

        ch = new int[10000 + 1];

        BFS(s);
        System.out.println(L);


    }
    private static void BFS(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        ch[s]=1;



        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int cur = q.poll();

                if(cur==e) return;


                for(int k=0;k<3;k++){
                    int nx = cur + dx[k];
                    if(1<=nx && nx<=10000 && ch[nx]==0 ){
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            L++;


        }

    }
}
/*
최소횟수?bfs

             d(5)
         /1   |-1  5\
        d(6)

        bfs의 레벨?



 */