package java_codingTest_study.section9_graph;
//25 02 12

import java.util.*;
public class s9_01_graph {
    static int[]arr;
    static int n,total;
    static String answer="NO";
    static boolean flag=false;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n]; // [ 1 3 5 6 7 10]
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        total=0;

        for (int i = 0; i < n; i++) total += arr[i];
        if(total%2!=0) {
            System.out.println(answer);
            return;
        }
        DFS(0,0);
        System.out.println(answer);
    }
    private static void DFS(int L, int sum){
        if(flag) return;
        if(L==n){ // total/2 = sum도 가능, void main에서 if문 안쓰고 total-sum==sum도 가능
            if(total/2==sum){
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(L + 1,sum+arr[L]);
            DFS(L + 1, sum);
        }
    }
}
