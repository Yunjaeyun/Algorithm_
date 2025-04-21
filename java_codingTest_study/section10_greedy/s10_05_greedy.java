package java_codingTest_study.section10_greedy;
//25 02 23
import java.util.*;

class Edge{
    int vex, cost;
    Edge(int v,int c){
        this.vex=v;
        this.cost = c;
    }

}
public class s10_05_greedy {
    static List<List<Edge>> graph;
    static int[] dis;
    private static void solution(int v){
        Queue<Edge> q = new PriorityQueue<>();
        dis[v]=0;
        q.add(new Edge(v,0));
        while(!q.isEmpty()){
            Edge tmp=q.poll();

            int now= tmp.vex;
            int nowCost= tmp.cost;

            if(nowCost>dis[now])continue;

            for(Edge ob:graph.get(now)){
                if(nowCost+ob.cost<dis[ob.vex]){
                    dis[ob.vex]=nowCost+ob.cost;
                    q.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dis = new int[n + 1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        graph = new ArrayList<>();

        for(int i=0;i<m;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=m;i++){
            int a = sc.nextInt();
            int vex = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Edge(vex,cost));
        }
        solution(1);
        for(int i=1;i<=m;i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+":"+dis[i]);
            else System.out.println("impossible");
        }

    }
}
