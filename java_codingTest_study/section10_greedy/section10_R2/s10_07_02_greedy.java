package java_codingTest_study.section10_greedy.section10_R2;
//25 03 25


import java.util.*;
class Edge12 implements Comparable<Edge12>{
    int vex, cost;
    Edge12(int v, int c){
        this.vex=v;
        this.cost=c;
    }
    @Override
    public int compareTo(Edge12 other){
        return this.cost - other.cost;
    }
}
public class s10_07_02_greedy {
    static int ch[];
    static List<List<Edge12>> graph = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        ch = new int[v + 1];

        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge12(b, c));
            graph.get(b).add(new Edge12(a, c));
        }

        PriorityQueue<Edge12> q = new PriorityQueue<>();
        q.offer(new Edge12(1,0));


        int answer=0;

        while(!q.isEmpty()){
            Edge12 cur = q.poll();
            if(ch[cur.vex]==0){
                ch[cur.vex]=1;
                answer+=cur.cost;

                for(Edge12 ob:graph.get(cur.vex)){
                    if(ch[ob.vex]==0) q.offer(new Edge12(ob.vex, ob.cost));
                }
            }

        }
        System.out.println(answer);

    }
}
