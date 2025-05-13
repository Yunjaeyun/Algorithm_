package java_codingTest_study.section12_etc_graph;
//25 04 24

import java.util.*;
public class s12_08_5014 {
    static boolean[]visited;
    static int u,d,g,f;

    static Queue<Integer> q = new ArrayDeque<>();

    static int L=0;

    static boolean flag=false;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        int s = sc.nextInt();

        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        int[]arr={u,-d};


        visited = new boolean[f+1];

        q.add(s);
        bfs(s,arr);

        if(flag) System.out.println(L);
        else System.out.println("use the stairs");


    }
    private static void bfs(int s, int[] arr){

        while(!q.isEmpty()){
            int len = q.size();

            for(int j=0;j<len;j++){
                int x = q.poll();

                if(x==g){
                    flag=true;
                    return;
                }

                for(int i=0;i<2;i++){
                    int nx = x+arr[i];

                    if(1<=nx && nx<= f &&!visited[nx]){
                        visited[nx]=true;
                        q.offer(nx);
                    }

                }
            }
            L++;
        }
    }
}
/*
dis 1 2 3 4 5 6 7 8 9 10
 [    1                   ]


10 1 10 2 1
 1 2  3 4 5
1 3 5 7 9 10
 */
