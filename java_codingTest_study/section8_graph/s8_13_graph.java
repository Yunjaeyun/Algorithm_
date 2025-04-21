package java_codingTest_study.section8_graph;
//25 02 10
import java.util.*;
public class s8_13_graph {
    static int n,m=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] distance, visited;

    private void BFS(int v){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        visited[v]=1;
        distance[v] = 0;

        while (!q.isEmpty()) {
            int cv = q.poll();
            for(int nv: graph.get(cv)){
                if(visited[nv]==0){
                    visited[nv]=1;
                    distance[nv]=distance[cv]+1;

                    q.offer(nv);
                }
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        distance = new int[n + 1];
        visited = new int[n + 1];
        s8_13_graph t = new s8_13_graph();
        t.BFS(1);


        for(int i=2; i<=n;i++){
            System.out.println(i + " : " + distance[i]);
        }
    }
}
// 특이쓰.. dfs는 재귀로 , bfs는 큐로..ㅋ