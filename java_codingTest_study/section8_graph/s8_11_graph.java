package java_codingTest_study.section8_graph;
//25 02 09
/*
정점 개수가 많아지면 저 인접행렬(2차원 배열)을 하면 무작위에 메모리 낭비도 되고 시간 복잡도도 길어진다. 인접리스트로 해야함.

1. 시작 노드부터 탐색합니다!
2. 현재 방문한 노드를 visited_array 에 추가합니다!
3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드에 방문합니다!
 */
import java.util.*;
public class s8_11_graph {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{               //visited 처리를 어떻게 할것이냐가 관건
            for(int i=1; i<=n;i++){
                if(graph[v][i]==1 && ch[i]==0 ){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }

        }

    }
    public static void main(String[] args){
        s8_11_graph T = new s8_11_graph();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new int[n+1][n+1];
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph[a][b]=1;
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }

}
/*
인접행렬(인접 2차원 배열)

[     0 1 2 3 4
   0 [0,0,0,0,0],
   1 [0,0,1,0,1], -> 1번 노드의 인접 노드는 2와 4임을 알수있음
   2 [0,0,0,0,0],
   3 [0,0,0,0,0],
   4 [0,0,0,0,0],
]

 */