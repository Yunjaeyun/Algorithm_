package java_codingTest_study.section9_graph;
//25 04 22 0122

import java.util.*;
public class s9_08_graph_2 {
    static int result[];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        result = new int[m];

        combi(m,0);

    }
    private static void combi(int L,int n){
        if(L==n){

        }else{

        }
    }
}
/*

          0, 3
        /3 |6 \9
        1, 6
      /|6\9
    2, 9
   /|\9
   3

 */