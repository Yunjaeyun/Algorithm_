package java_codingTest_study.section11_dp.section11_R2;

import java.util.Arrays;
import java.util.Scanner;

//25 03 24
public class s11_05_dp {
    static int arr[];
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        dp = new int[m+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1]=1;
        dp[0]=0;

        for(int j=0;j<3;j++){
            for(int i=arr[j];i<=m;i++){
                dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
            }
        }
        System.out.println(dp[m]);

    }
}
/* 1 2 5
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
0   1   2   3   4
    고민.. 이 dp값을 넣을때 if조건을 나누기->몫으로하려나?

    아 기억났다. 각각의 인덱스의 의미는 -> 해당금액을 거슬러줄수있는 최소 동전 종류수
                                     dp[4]=dp[4- 2원]+1
 */