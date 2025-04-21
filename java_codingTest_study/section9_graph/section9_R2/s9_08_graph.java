package java_codingTest_study.section9_graph.section9_R2;
//25 03 18

import java.util.*;
public class s9_08_graph {
    static int[]pm;
    static int n,f;
    static int []ch;
    static int[] combi;
    static int [][]memo;
    static boolean flag=false;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //4
        f = sc.nextInt();

        combi = new int[n];
        memo = new int[n + 1][n + 1];

        for(int i=0;i<n;i++){
            combi[i] = nCr(n - 1, i);
        }

        pm = new int[n];
        ch = new int[n + 1];
        DFS(0);
    }
    private static int nCr(int N, int R){
        if (memo[N][R]!=0) return memo[N][R];
        if(N==R || R==0) return 1;
        else{
            int value = nCr(N - 1, R - 1) + nCr(N - 1, R);
            memo[N][R]=value;
            return value;
        }
    }
    private static void DFS(int L){
        if(flag) return;
        if(L==n){
            int sum=0;
            for(int i=0;i<n;i++){
                sum += (combi[i] * pm[i]);
            }
            if(sum==f) {
                for(int x:pm) System.out.print(x + " ");
                flag=true;
            }

        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L] = i;
                    DFS(L + 1);
                    ch[i]=0;
                }
            }
        }
    }
}
/*


pm 0 1 2 3 4
   1

         D(0)
         /1|2|3\4
      D(1)

1234
1243
 */
