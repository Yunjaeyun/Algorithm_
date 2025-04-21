package java_codingTest_study.section9_graph;
//25 02 12
import java.util.*;
import java.lang.*;
public class s9_05_graph {
    static int n;
    static int []arr;
    static int m;
    static int minimum = Integer.MAX_VALUE;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        reverse(arr);

        m=sc.nextInt();

        DFS(0,0);
        System.out.println(minimum);
    }

    private static void DFS(int L,int sum){
        if(sum>m) return;
        if(L>=minimum) return;
        if(sum==m){
            minimum = Math.min(minimum, L);
        }else{
            for(int i=0;i<n;i++){
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    private static void reverse(int []arr){
        for(int i=0; i<n/2; i++){
            int temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
    }
}
