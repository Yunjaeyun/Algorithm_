package java_codingTest_study.section12_etc_graph;
//25 05 04 06b08

import java.util.*;
public class s12_14_12851 {

    static int n, target;

    static int visited[];

    static int count=0;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        target =sc.nextInt();

        visited = new int[100_000 + 1];

        bfs(n);
        System.out.println(visited[target]-1);
        System.out.println(count);
    }
    private static void bfs(int n){
        Queue<Integer> q = new ArrayDeque<>();

        visited[n]=1;
        q.offer(n);

        while(!q.isEmpty()){
            int len = q.size();

            for(int p=0;p<len;p++){
                int cur = q.poll();

                if(cur== target){
                    if(visited[cur]-1<minTime){
                        minTime = visited[cur]-1;
                        count=1;

                    }else if(visited[cur]-1 == minTime){
                        count++;
                    }
                    continue;
                }

                for(int next:new int[]{cur+1,cur-1, cur*2}){
                    if(0<=next && next<=100_000){
                        if(visited[next]==0 || visited[next]==visited[cur]+1){
                            visited[next] = visited[cur] + 1;
                            q.offer(next);
                        }
                    }


                }

                }
            }


    }
}
/*
5 10  20 19 18 17
5  4  8  16 17
 */