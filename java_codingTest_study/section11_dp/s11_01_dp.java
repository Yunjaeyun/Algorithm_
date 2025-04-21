package java_codingTest_study.section11_dp;
//25 02 24

import java.util.*;
public class s11_01_dp {
    static int memo[];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new int[n + 1];

        int answer=dp(n);
        System.out.println(answer);
    }
    private static int dp(int n){
        if (memo[n]!=0)
            return memo[n];


        if(n==1) return 1;
        else if(n==2) return 2;

        int value=dp(n-1)+dp(n-2);
        memo[n]=value;
        return memo[n];
    }

}
