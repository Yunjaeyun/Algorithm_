package java_codingTest_study.section10_greedy;
import java.util.*;
public class s10_06_01_greedy {

    static List<List<Integer>> graph;
    static int[] visited;

    private static void BFS(int s){
//        graph.sort((a, b) -> Integer.compare(a.get(0),b.get(0));
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s]=1;

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int neighbor:graph.get(cur)){
                if(visited[neighbor]==0){
                    visited[neighbor]=1;
                    q.offer(neighbor);
                }
            }
        }


    }
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        visited = new int[n + 1];

        for(int i=0;i<=n;i++){ //*
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // 양방향노드**
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        BFS(A);

        if(visited[B]==1) System.out.println("YES");
        else  System.out.println("NO");
    }
}
