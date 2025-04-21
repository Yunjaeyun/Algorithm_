package java_codingTest_study.section9_graph.section9_R1;
//25 03 04

import java.util.*;
public class s9_02_graph {

    static int c,n;
    static int[]arr;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n+1];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        DFS(0, 0, arr);
        System.out.println(answer);

    }
    private static void DFS(int L,int sum,int[]arr){
        if(sum>c) return;
        if(L==n){
            answer = Math.max(answer, sum);
        }else{
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

}
/*
x를 태우거나 안태우거나
          D(0,0)
          /O 81   X \
        D(1,81)   D(0,81)

 */
