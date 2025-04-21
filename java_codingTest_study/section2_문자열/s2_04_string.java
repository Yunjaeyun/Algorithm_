package java_codingTest_study.section2_문자열;
//25 02 27

import java.util.*;
public class s2_04_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for(int k=0;k<n;k++){
            String line = sc.nextLine();

            int len = line.length();
            String s = "";
            for(int i=len-1;i>=0;i--){
                s += line.charAt(i);
            }
            System.out.println(s);
            s = "";
        }
    }
}
// 단일 for문 stringbuilder.reverse()