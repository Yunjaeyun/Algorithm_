package java_codingTest_study.section8_graph;
// 2025 02 09
/*

BFS
 1 루트노드를 큐에 넣습니다
 2 현재 큐의 노드를 빼서 visited에 추가한다.
 3 현재 방문한 노드와 인접한 노드 중 방문하지 않는 노드를 큐에 추가한다.
 4 2부터 반복한다
 5 큐가 비면 탐색을 종료한다.
 */
import java.util.*;
public class s8_08_graph {
    static int answer = 0;
    static int []dis={1, -1, 5};
    static int[] visited;
    private static int  BFS(int s, int e){
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new int[10001];
        visited[s]=1;
        int level=0;
        queue.offer(s);

        while(!queue.isEmpty()){
            int len = queue.size(); //1

            for(int i=0;i<len;i++){
                int cur = queue.poll();

                for(int j=0;j<3;j++){
                    int adjacent_node = cur + dis[j]; //6 4 10
                    if( adjacent_node>0 && adjacent_node<10001 && visited[adjacent_node]==0 ){
                        queue.offer(adjacent_node);
                        visited[adjacent_node]=1;
                    }
                    if(adjacent_node==e) return ++level;

                }

            }
            level++;

        }
        return level;

   }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();


        // 1, -1, 5 순서대로?
        // ox ox  ox 뭔가 이것도 이전문제처럼 경우의수 문제인듯 한데, 재귀로만 풀어야하는건가? * 큐(자료구조) 사용하는 방법은?
        System.out.println(BFS(s, e));

    }
}
