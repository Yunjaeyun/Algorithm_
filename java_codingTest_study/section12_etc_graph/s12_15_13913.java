package java_codingTest_study.section12_etc_graph;
//25 05 08

import java.util.*;
public class s12_15_13913 {

    static int visited[],prev[];

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        visited = new int[100_000 + 1];
        prev = new int[100_000 + 1];

        bfs(n,k);
        System.out.println(visited[k] - 1);

        List<Integer> arr = new ArrayList<>();
        for (int i = k; i != n; i = prev[i]) {
            arr.add(i);
        }
        arr.add(n);

        Collections.reverse(arr);
        for(int x:arr) System.out.print(x + " ");



    }
    private static void bfs(int n, int k){
        Queue<Integer> q = new ArrayDeque<>();
        visited[n]=1;
        q.offer(n);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur==k){
                return;
            }

            for(int next:new int[]{cur+1,cur-1,cur*2}){

                if(0<=next && next<=100_000){
                    if(visited[next]==0){
                        visited[next] = visited[cur] + 1;

                        prev[next]=cur;

                        q.offer(next);
                    }
                }
            }
        }
    }
}
