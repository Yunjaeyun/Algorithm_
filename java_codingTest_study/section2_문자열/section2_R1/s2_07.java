package java_codingTest_study.section2_문자열.section2_R1;

import java.util.Scanner;

//250417
public class s2_07 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String reversed = new StringBuffer(s).reverse().toString();

        if(s.equalsIgnoreCase(reversed)) System.out.println("YES");
        else System.out.println("NO");
    }
}
