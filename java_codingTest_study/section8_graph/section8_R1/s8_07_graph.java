package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

import java.util.*;
public class s8_07_graph {
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[]args){
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1,4,5));
        graph.put(3, Arrays.asList(1,6,7));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));
        graph.put(7, Arrays.asList(3));


        bfs(1);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();

        q.offer(n);

        while (!q.isEmpty()){
            int tmp = q.poll();
            visited.add(tmp);

            for(int x:graph.get(tmp)){
                if(!visited.contains(x)) q.offer(x);
            }
        }

        System.out.println(visited);
    }
}
/*
q.offer(Startnode)해야했는데,
visited에 해버렸네
 */