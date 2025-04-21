package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
public class s9_02_graph {
    static List<Integer> arr=new ArrayList<>();
    static int c,n;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();

        for(int i=0;i<n;i++){
            int a= sc.nextInt();
            arr.add(a);
        }
        arr.sort((a, b) -> b - a);
        DFS(0,0);

        System.out.println(answer);


    }
    private static void DFS(int L, int sum){
        if(sum>c) return;
        if(L==n){
            answer=Math.max(answer,sum);
            return;
        }else{
            DFS(L + 1, sum + arr.get(L));
            DFS(L + 1, sum);
        }
    }
}
/*
                  d(0,0)
               o/81    \x
              d(1,81)    d(2,0)
             /

 */