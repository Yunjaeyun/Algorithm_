package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_03_recursive {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result=recursive(n);
        System.out.println(result);
    }
    private static int recursive(int n){
        if(n==1) return 1;
        else{
            return n * recursive(n - 1);
        }
    }
}
/*

r(1)
r(2)
r(3)
r(4)
r(5)
 */