package java_codingTest_study.section9_graph.section9_R1;
//25 03 05
import java.util.*;
public class s9_05_graph {
    static Integer[]arr;
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new Integer[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();

        DFS(0,0);
        System.out.println(answer);

    }
    private static void DFS(int L, int sum){
        if(L>answer) return;
        if(sum>m)return;
        if(sum==m){
            answer = Math.min(answer, L);
        }else{
            for(int i=0;i<n;i++){
                DFS(L + 1, sum + arr[i]);
            }

        }
    }
}
/*
                       D(0,0)
                      1  2  5
                D(1,1) D(1,2) D(1,5)
             1 2 5
     D(2,2) D(2,3) D(2,8)


     int[]배열은 reverseorder()가 안됨. integer[] 는 가능
 */