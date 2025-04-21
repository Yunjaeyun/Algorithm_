package java_codingTest_study.section9_graph;
//25 02 12

import java.util.*;
public class s9_04_graph {
    static int n,m;
    static int visited[];

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //3 3까지
        m = sc.nextInt(); //3 2개 뽑
        visited =new int[m];

        DFS(0);
    }
    private static void DFS(int L){
        if(L==m){
            for(int x:visited) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                visited[L]=i;
                DFS(L+1);
            }
        }

    }
}
/*
    D(0)
  o/    \x
 D(1)    D(1)
 */

//visited[L]을 o or x
//        ->   1 or 0 으로 표현한것처럼 visited[L]=0, visited[L]=1
// visited[L] = 1 2 3

/*
      D(0)
   1/  2|  \3
 D(1) D(1) D(1)

 */
