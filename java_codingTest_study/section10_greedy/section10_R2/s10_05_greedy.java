package java_codingTest_study.section10_greedy.section10_R2;
//25 03 24

import java.util.*;
class Edge implements Comparable<Edge>{
    int vex, cost;
    Edge(int v, int c){
        this.vex=v;
        this.cost=c;
    }
    @Override
    public int compareTo(Edge other){
        return this.cost - other.cost;
    }
}
public class s10_05_greedy {
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dis ;
    static int n, m;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0; // 시작 정점은 비용 0

        for(int i=0;i<=n;i++){ //**
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int vex = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Edge(vex, cost));
        }
        sol();
    }
    private static void sol(){
        Queue<Edge> q = new ArrayDeque<>();
        q.add(new Edge(1,0));


        while(!q.isEmpty()){
            Edge cur = q.poll();
            int now=cur.vex;
            int nowCost = cur.cost;

            //가려는데, 기존에 저장된 값보다 크다면 의미없음.
            if(nowCost>dis[now]) continue;
            for(Edge ob:graph.get(now)){
                if(ob.cost +dis[now] < dis[ob.vex]){ //목표는 최소니까
                    dis[ob.vex] = ob.cost + dis[now];
                    q.add(new Edge(ob.vex, ob.cost + dis[now]));
                }
            }

        }

        for(int i=2;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) System.out.println(i + " : possible");
            else System.out.println(i + ": " + dis[i]);
        }

    }
}
/*
0 1 2  3  4  5  6
  0 12 4  9
    2
 */