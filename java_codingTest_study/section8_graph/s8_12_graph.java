package java_codingTest_study.section8_graph;
//25 02 10
import java.util.*;
public class s8_12_graph {
    static int n,m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int visited[];
    private void DFS(int v){
        if(v==n) answer++;
        else{
            for(int cur_node: graph.get(v)){
                if(visited[cur_node]==0){
                    visited[cur_node]=1;
                    DFS(cur_node);
                    visited[cur_node] = 0;
                }

            }
        }

    }
    public static void main(String[]args){
        s8_12_graph t = new s8_12_graph();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        visited=new int[n+1];

        for(int i=0; i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }
        visited[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
}
/*

[
    0-[x]
    1-[2,3,5]
    2-[]
    3-[]
]

 */