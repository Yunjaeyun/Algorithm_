package java_codingTest_study.section8_graph.section8_R1;
//25 03 03,04

import java.util.*;
public class s8_12_graph {
    static List<List<Integer>> graph;
    static int[]ch;
    static int n;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n + 1];
        graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        ch[1]=1;
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int s){
        if(s==n){
            answer++;
        }else{
            for(int x:graph.get(s)){
                if(ch[x]==0){
                    ch[x]=1;
                    dfs(x);
                    ch[x]=0;
                }
            }
        }
    }
}
// 리스트 자체에 번호를 매긴다. 몇번 리시트 1-[2,3,4]