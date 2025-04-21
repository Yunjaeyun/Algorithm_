package java_codingTest_study.section11_dp.section11_R1;
//25 03 11

import java.util.*;
public class s11_02_dp {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result=sol(n+1);
        System.out.println(result);
    }
    private static int sol(int n){
        if(n==2) return 2;
        else if(n==1) return 1;

        return sol(n-2)+sol(n-1);
    }
}
