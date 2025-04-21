package java_codingTest_study.section10_greedy;

import java.util.*;

class Edge1 {
    int v1,v2,cost;
    Edge1(int v1, int v2, int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }
}
public class s10_07_01_greedy {
    static List<Edge1> arr;
    static int []unf;


    private static int Find(int v){
        if(unf[v]==v) return v;
        else return unf[v] = Find(unf[v]);
    }
    private static void Union(int a,int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        arr = new ArrayList<>();
        unf = new int[v+1];
        for (int i = 1; i <= v; i++) unf[i] = i;


        for(int i=0;i<e;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Edge1(v1, v2, cost));
        }
        arr.sort((a, b) -> a.cost-(b.cost));

        int result=0;
        for(Edge1 ob:arr){
            int fa=Find(ob.v1);
            int fb=Find(ob.v2);

            if(fa==fb){
                continue;              //집합이 같으면 continue? 다르면
            }
            else{
                Union(fa, fb);
                result+=ob.cost;
            }
        }
        System.out.println(result);
    }
}
