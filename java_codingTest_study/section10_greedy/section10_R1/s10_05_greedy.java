package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Edge2 implements Comparable<Edge2>{
    int vex,cost;
    Edge2(int v,int c){
        this.vex=v;
        this.cost=c;
    }
    //poll할때 뭘 기준으로 작은 값빼줄건지
    @Override
    public int compareTo(Edge2 other){
        return this.cost-other.cost;
    }
}
public class s10_05_greedy {
    static List<List<Edge2>> graph = new ArrayList<>();
    static int[]dis;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1]=0;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }


        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int vex = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Edge2(vex, cost));

        }
        sol(1);
        for(int i=2;i<=n;i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i + ":" + dis[i]);
            else System.out.println(i+":impossible");
        }
    }
    private static void sol(int v){
        PriorityQueue<Edge2> q = new PriorityQueue<>();
        q.offer(new Edge2(1, 0));

        while(!q.isEmpty()){          //                     0 1 2 3 4 5 6
            Edge2 cur = q.poll();    // vex 1 cost 0  dis [  0 m m m m m ]  dis값은 누적된것이다.
            int cur_cost = cur.cost;//                           12<
            int cur_vex=cur.vex;
            if(cur_cost>dis[cur_vex]) {
                continue;
            }

            for(Edge2 ob :graph.get(cur.vex)){ // 1-(2,30)(3,40)..
                //들어오는값ob이 현재 비용보다 더 싸다면(=올바른 인접노드)
                if(cur_cost + ob.cost <dis[ob.vex]){
                    dis[ob.vex]=cur_cost+ob.cost;
                    q.offer(new Edge2(ob.vex, cur_cost + ob.cost));
                }
            }
        }

    }
}
/*
6 9
1 2 12
 1 3 4
 2 1 2
 2 3 5
 2 5 5
 3 4 5
 4 2 2
 4 5 5
 6 4 5

      0 1 2  3 4  5 6
 dis [  0 12 4 m  5 m]


3 4
우선순위 큐 아닐때 비교 ㄱㄱ


 */