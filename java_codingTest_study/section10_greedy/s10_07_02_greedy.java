package java_codingTest_study.section10_greedy;
//25 02 24
import java.util.*;

class Edge2 implements Comparable<Edge2>{
    int v2, cost;
    Edge2(int v2,int cost){
        this.v2=v2;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge2 other){
        return this.cost - other.cost;
    }
}
public class s10_07_02_greedy {
    static List<List<Edge2>> graph;
    static int[] ch;
    static int answer=0;
    private static void sol(){
        Queue<Edge2> q = new PriorityQueue<>();
        //* 2. 초기값을 생각하자. -> 어디로 두든간에 상관없다. excel참고
        q.offer(new Edge2(1,0));

        while(!q.isEmpty()){
            Edge2 tmp = q.poll();

            if(ch[tmp.v2]==0){
                ch[tmp.v2]=1;
                answer+=tmp.cost;
                for(Edge2 ob:graph.get(tmp.v2)){

                    q.offer(new Edge2(ob.v2, ob.cost));
                }
            }

        }

    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        graph = new ArrayList<>();
        for(int i=0; i<=v;i++){
            graph.add(new ArrayList<>());
        }

        ch = new int[v + 1];

        for(int i=0;i<e;i++){ //* 1. 인접그래프로 풀꺼면 양방향 노드임을 지시해줄것.
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(v1).add(new Edge2(v2, cost));
            graph.get(v2).add(new Edge2(v1, cost));
        }

        sol();
        System.out.println(answer);

    }
}
