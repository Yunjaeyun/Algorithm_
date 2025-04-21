package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Edge3 implements Comparable<Edge3>{
    int vex,cost;
    Edge3(int v,int c){
        this.vex=v;
        this.cost=c;
    }
    @Override
    public int compareTo(Edge3 other){
        return this.cost-other.cost;
    }
}
public class s10_07_02_greedy {
    static List<List<Edge3>> graph = new ArrayList<>();
    static int v,e;
    static int[]ch;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        ch = new int[v + 1];

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge3(b,c));
            graph.get(b).add(new Edge3(a,c));

        }
        sol();

    }
    private static void sol(){
        PriorityQueue<Edge3> q = new PriorityQueue<>();
        q.offer(new Edge3(1, 0));

        int sum=0;

        while(!q.isEmpty()){
            Edge3 cur=q.poll();
            if(ch[cur.vex]==0){
                ch[cur.vex]=1;
                sum+=cur.cost;

                for(Edge3 ob:graph.get(cur.vex)){
                    if(ch[ob.vex]==0) q.offer(new Edge3(ob.vex, ob.cost));
                }

            }
        }
        System.out.println(sum);

    }
}
