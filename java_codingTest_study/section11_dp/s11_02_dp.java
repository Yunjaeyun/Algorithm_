package java_codingTest_study.section11_dp;
//25 02 24

import java.util.*;
public class s11_02_dp {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer=dp(n + 1);
        System.out.println(answer);

    }
    private static int dp(int n){
        if(n==1) return 1;
        else if(n==2) return 2;

        return dp(n - 2) + dp(n - 1);
    }
}
