package java_codingTest_study.section9_graph;
//25 04 22 0122

import java.util.*;
public class s9_09_graph_2 {
    static int cm[];
    static int arr[];
    static int n,m;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

         arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i+1;

        cm = new int[m];

        DFS(0,1);

    }
    private static void DFS(int L, int s){ //Level
        if(L==m){
            for(int x:cm) System.out.print(x + " ");
            System.out.println();

        }else{
            for(int i=s;i<n;i++){
                cm[L]=i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
/*





















          0, 1
        /1 |2|3 \4
        1, 2
    / |2|3 \4


D(1,2) for i=2
D(0,1)

 */