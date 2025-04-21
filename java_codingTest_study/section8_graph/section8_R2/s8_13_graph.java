package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_13_graph {
    static int n, m;
    static List<List<Integer>> graph=new ArrayList<>();
    static int[]ch;
    static int[]dis;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ch=new int[n+1];
        dis=new int[n+1];
        dis[0]=0;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(1);
        for(int i=2;i<=n;i++){
            System.out.print(i + ":" + dis[i]);
            System.out.println();
        }
    }
    private static void BFS(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        ch[s]=1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int cur = q.poll();

                for(int x:graph.get(cur)){
                    if(ch[x]==0){
                        ch[x]=1;
                        q.offer(x);

                        dis[x] = dis[cur] + 1;
                    }
                }
            }
        }
    }
}
/*
거리 물어보네?
최소네? bfs
아근데 dis[]배열 사용하겠네/
누적되겠네 +1로
 */