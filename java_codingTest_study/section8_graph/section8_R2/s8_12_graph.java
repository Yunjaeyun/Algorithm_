package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_12_graph {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n,m;
    static int[]ch;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n + 1];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        DFS(1);
        System.out.println(answer);
    }
    private static void DFS(int L){
        if(L==n){
            answer++;
        }else{
            for(int x:graph.get(L)){
                if(ch[x]==0){
                    ch[x]=1;
                    DFS(x);
                    ch[x]=0;
                }
            }
        }
    }
}
/*

d(2) i=3
d(1) i=2

 */