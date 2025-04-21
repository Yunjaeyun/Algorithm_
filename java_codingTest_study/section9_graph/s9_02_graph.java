package java_codingTest_study.section9_graph;
//25 02 12
import java.util.*;
public class s9_02_graph {
    static int c, n;
    static int []arr;
    static int maximum=Integer.MIN_VALUE;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        DFS(0, 0);
        System.out.println(maximum);
    }
    private static void DFS(int L, int sum){
        if(sum>c) return;
        if(L==n){
            if(sum>maximum){ //두 코드대신 이것도 가능-> maximum = Math.max(maximum, sum)
                maximum=sum;
            }
        }else{
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum );
        }
    }
}
