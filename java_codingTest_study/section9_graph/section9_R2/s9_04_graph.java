package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
public class s9_05_graph {
    static int n, m;
    static int pm[];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        pm = new int[m];

        DFS(0);
    }
    private static void DFS(int L){
        if(L==m){
            for(int i=0;i<m;i++){
                System.out.print(pm[i]);
            }
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }
}

/*
pm=[1 ,1 ]
        d(0,
       /1|2\3
     d(1,
     /|\
    d(2



D(1) I=2 [1,2]
D(0) i=1 [1, ]
 */