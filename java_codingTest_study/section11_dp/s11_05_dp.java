package java_codingTest_study.section11_dp;
// 25 02 25
import java.util.*;
public class s11_05_dp {
    static int[] dy;
    static int n, m;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        m = sc.nextInt();
        dy = new int[m + 1];

        System.out.println(sol(arr));
    }

    private static int sol(int [] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0; //* 초기값

        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=m;j++){
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        return dy[m];
    }
}
