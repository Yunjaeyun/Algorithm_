package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10,11

import java.util.*;
class Edge4 implements Comparable<Edge4>{
    int a,b,cost;
    Edge4(int a,int b, int cost){
        this.a=a;
        this.b=b;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge4 other){
        return this.cost-other.cost;
    }
}
public class s10_07_01_greedy {
    static int []unf;
    static List<Edge4> arr=new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];
        for(int i=1;i<=v;i++) unf[i]=i;

        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            arr.add(new Edge4(a, b, cost));
        }
        arr.sort(null);

        int sum=0;
        for(Edge4 ob:arr){
            int fa = Find(ob.a);
            int fb = Find(ob.b);
            if(fa!=fb)
                sum += ob.cost;
                Union(fa, fb);
        }
        System.out.println(sum);

    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    private static int Find(int a){
        if(a==unf[a]) return a;
        else return unf[a] = Find(unf[a]);
    }
}
