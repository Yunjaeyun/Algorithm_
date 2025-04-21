package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
public class s9_05_graph {
    static int[]arr;
    static int n, m;
    static int L=0;
    static int[] ch;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt();
        ch=new int[m+1];

        BFS( 0);

        System.out.println(L);
    }
    private static void BFS( int sum){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(sum);

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int cur = q.poll();

                if(cur==m) return;

                for(int j=0;j<3;j++){
                    int nx = cur + arr[j];
                    if(0<=nx && nx<=m && ch[nx]==0){
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
         d(0,0)
          /1|2\5
      d(1,1) d(1,2)  d(1,5)
      /
    d(2,2)
 */
