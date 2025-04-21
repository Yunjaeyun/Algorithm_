package java_codingTest_study.section10_greedy.section10_R2;
//25 03 25

import java.util.*;
class Edge5{
    int vex1,vex2, cost;
    Edge5(int v1,int v2,int c){
        this.vex1=v1;
        this.vex2=v2;
        this.cost=c;
    }
}
public class s10_07_01_greedy {
    static int[]unf;
    static List<Edge5> graph = new ArrayList<>();
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a,int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];
        for(int i=1;i<=v;i++){
            unf[i] = i;
        }



        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.add(new Edge5(a,b, cost));
        }
        graph.sort((a, b) -> a.cost - b.cost);
        int answer=0;
        for(Edge5 ob:graph){
            int a=ob.vex1;
            int b=ob.vex2;

            if(Find(a)==Find(b)) continue;
            Union(a, b);
            answer+=ob.cost;
        }
        System.out.println(answer);
    }
}

