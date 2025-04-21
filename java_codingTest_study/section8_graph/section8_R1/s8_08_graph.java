package java_codingTest_study.section8_graph.section8_R1;
//25 03 03
import java.util.*;
public class s8_08_graph {
    static int e;
    static int[] ch;
    static int L;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        e = sc.nextInt();

        ch = new int[10001];

        bfs(s, e);
        System.out.println(L);

    }

    private static void bfs(int s, int e){
        Queue<Integer> q = new ArrayDeque<>();
        int dis[] = {-1, 1, 5};

        q.offer(s);
        L=0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int x = q.poll();
                if(x==e) return;

                for(int j=0;j<3;j++){
                    int nx = x + dis[j];
                    if(0<nx && nx<=10000  && ch[nx]==0) {
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            L++;

        }

    }
}
/*
인접한 노드들이 x+1, x-2, x+5 인거겠지..?
☑️ ch[nx]!=0    ch[nx]==0 헷갈림주의
☑️ 문제를 잘 읽어보면, 종료조건이 있었음을 명시함.


 */
