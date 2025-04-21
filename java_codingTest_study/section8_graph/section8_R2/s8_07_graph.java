package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_07_graph {
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[]args){
        for(int i=0;i<=7;i++){
            graph.add(new ArrayList<>());
        }
       // 1-[2.3]

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);

        graph.get(4).add(2);

        graph.get(5).add(2);

        graph.get(3).add(1);
        graph.get(3).add(6);
        graph.get(3).add(7);

        graph.get(6).add(3);
        graph.get(7).add(3);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        int ch[] = new int[7 + 1];
        ch[1]=1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int x:graph.get(cur)){
                if(ch[x]==0){
                    ch[x]=1;
                    q.offer(x);
                }
            }
        }

    }
}
