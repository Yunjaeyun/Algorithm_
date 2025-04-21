package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_04_recursive {
    static int[]memo;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new int[n + 1];
        fibo(n);


        for(int i=1;i<=n;i++){
            System.out.print(memo[i] + " ");
        }
    }
    private static int fibo(int n){
        if (memo[n]!=0) return memo[n];
        if(n==1 || n==2){
            return memo[n]=1;
        }else{
            int value=fibo(n - 1) + fibo(n - 2);
            memo[n]=value;
            return memo[n];
        }
    }
}

/*


fibo(3)

1 1 2
fibo(2)
 */
