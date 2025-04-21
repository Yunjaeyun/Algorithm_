package java_codingTest_study.section8_graph.section8_R1;
//25 03 03,04

import java.util.*;
public class s8_13_graph {
    static int n, m;
    static int[]ch;
    static int[]dis;
    static List<List<Integer>> graph;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dis=new int[n+1];
        ch = new int[n + 1];
        graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        bfs(1);

        for(int i=2;i<=n;i++){
            System.out.println(i + " :" + dis[i]);
        }
    }
    private static void bfs(int s){
        Queue<Integer> q=new ArrayDeque<>();
        ch[s]=1;

        q.offer(s);
        while(!q.isEmpty()){
            int len = q.size();

            int cur = q.poll();
            for(int x:graph.get(cur)){
                if(ch[x]==0){
                    ch[x]=1;
                    q.add(x);

                    dis[x]=dis[cur]+1;
                }
            }
        }
    }
}
