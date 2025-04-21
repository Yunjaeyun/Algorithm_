package java_codingTest_study.section8_graph;
import java.util.*;
import java.lang.*;
public class s8_05_graph {

    public static void main(String[]args){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));
        graph.put(7, Arrays.asList(3));

        System.out.print(DFS(graph, 1));
    }

    private static List<Integer> DFS(HashMap<Integer, List<Integer>> graph , int startNode){
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()){
            int curNode = stack.pop(); // curNode=1
            visited.add(curNode);
//            System.out.println("visited:"+ visited);

            List<Integer> adjacent_nodes = graph.get(curNode); //[2,3]

            for (int i = adjacent_nodes.size()-1; i>=0; i--) { //전위순회:왼쪽자식부터 원한다->i=0,i++ 하게되면
                                                                      // 들어가는 꼴은 오른쪽자식부터 들어가게됨
                int adjacent_Node = adjacent_nodes.get(i);
                if(!visited.contains(adjacent_Node)) stack.push(adjacent_Node);
            }
        }

        return visited;
    }
}
