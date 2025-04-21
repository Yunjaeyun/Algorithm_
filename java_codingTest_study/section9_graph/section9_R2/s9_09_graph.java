package java_codingTest_study.section9_graph.section9_R2;
//25 03 20

import java.util.*;
public class s9_09_graph {
    static int []cm;
    static int n,m;
    static int []ch;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();//4
         m = sc.nextInt();//2

        cm = new int[m];
        ch = new int[n + 1];

        DFS(0, 1);
    }
    private static void DFS(int L, int start){
        if(L==m){
            System.out.println(Arrays.toString(cm));
        }else{
            for(int i=start;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    cm[L]=i;
                    DFS(L + 1, i);
                    ch[i]=0;
                }

            }
        }
    }


}
/*  0 1
 cm 1
                     l, s
                 dfs(0,0)
                 /1|2|3\4
              d(1,1)
               2/3|/4
 */
