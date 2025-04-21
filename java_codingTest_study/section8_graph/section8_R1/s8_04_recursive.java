package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

import java.util.*;
public class s8_04_recursive {
    static int memo[];
    public static void main(String[]args){
        int n=10;
        memo = new int[n+1];
        int answer=fibo(n);
        System.out.println(Arrays.toString(memo));
    }

    private static int fibo(int n){
        if(memo[n]!=0) return memo[n];
        if(n==1 || n==2) return memo[n]=1;
        else{

            int value= fibo(n - 1) + fibo(n - 2);
            memo[n] = value;
            return memo[n];
        }
    }
}
/*


f2
f3
 */