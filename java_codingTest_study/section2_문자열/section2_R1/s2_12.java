package java_codingTest_study.section2_문자열.section2_R1;
//250416

import java.util.Scanner;

public class s2_12 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();

        int i=0;
        while(i<=line.length()-7){
            String s = line.substring(i, i + 7);
            s = s.replace("#", "1").replace("*", "0");
            int x = Integer.parseInt(s,2);
            System.out.print((char) x);

            i=i+7;
        }
    }
}
/*
28 length
 1 -7  8-14
i0 -6  7-13

 */