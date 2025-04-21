package java_codingTest_study.section10_greedy.section10_R2;
//25 03 25

import java.util.*;
public class s10_06_greedy {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ch[] = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int x = sc.nextInt();
        int y = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        ch[x]=1;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                int cur = q.poll();

                for(int next:graph.get(cur)){
                    if(ch[next]==0){
                        ch[next]=1;
                        q.offer(next);
                    }
                }
            }
        }

        for(int i=0;i<=n;i++){
//            System.out.println(i + " :" + ch[i]);
        }
        if(ch[y]==1) System.out.println("YES");
        else System.out.println("NO");



    }
}
