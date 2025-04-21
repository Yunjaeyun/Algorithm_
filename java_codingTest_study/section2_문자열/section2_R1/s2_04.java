package java_codingTest_study.section2_문자열.section2_R1;
//25 04 15

import java.util.*;
public class s2_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String reversed=new StringBuffer(sc.next()).reverse().toString();
            System.out.println(reversed);
        }

    }
}
