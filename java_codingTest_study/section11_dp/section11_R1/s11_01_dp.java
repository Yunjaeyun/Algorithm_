package java_codingTest_study.section11_dp.section11_R1;
//25 03 11
import java.util.*;
public class s11_01_dp {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer=sol(n);
        System.out.println(answer);
    }
    private static int sol(int n){
        if(n==1)return 1;
        else if(n==2) return 2;

        return sol(n - 1) + sol(n - 2);
    }
}
