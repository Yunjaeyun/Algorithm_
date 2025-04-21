package java_codingTest_study.section8_graph;
import java.util.*;
public class s8_07_graph {

    public static void main(String[]args){ //1:[2,3]
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4,5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));
        graph.put(7, Arrays.asList(3));

        System.out.println(BFS(graph, 1));
    }
    private static List<Integer> BFS(HashMap<Integer, List<Integer>> graph,int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();

        queue.offer(startNode);

        while (!queue.isEmpty()){
            int cur_node=queue.poll(); // 1
            visited.add(cur_node);

            List<Integer> adjacent_nodeS = graph.get(cur_node); //[2,3]
            for (int i = 0; i < adjacent_nodeS.size(); i++) {
                int adjacent_node = adjacent_nodeS.get(i);
                if(!visited.contains(adjacent_node)) queue.offer(adjacent_node);
            }
        }
        return visited;

    }
}
