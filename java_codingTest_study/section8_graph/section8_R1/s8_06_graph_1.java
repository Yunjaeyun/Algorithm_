package java_codingTest_study.section8_graph.section8_R1;
//25 02 12 나의 조건추가: 재귀 & Stack 둘다 풀어볼것
import java.util.*;
public class s8_06_graph_1 {
    static int n;
    static int visited[]; // 4칸 , [0][1][2][3]
    private void DFS(int L){
        if(L==n+1) { // L==n *5
            for(int i=1;i<visited.length;i++){
                if(visited[i]==1) System.out.print(i+" ");
            }
            System.out.println("");
        }
        else{
            visited[L]=1;
            DFS(L+1);
            visited[L]=0;
            DFS(L + 1); //
        }
    }
    public static void main(String[]args){
        s8_06_graph_1 t = new s8_06_graph_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new int[n + 1];
        t.DFS(1);
    }
}
