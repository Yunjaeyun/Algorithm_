package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.Scanner;
public class s8_01_recursive {
    static int n;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();

        recursive(n);
    }
    private static void recursive(int n){
        if (n<1) {
            return;
        } else {
            recursive(n-1);
            System.out.println(n);
        }
    }
}
/*
스택을 생각할것

r(1)
r(2)
r(3)

 */