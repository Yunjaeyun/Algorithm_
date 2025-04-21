package java_codingTest_study.section2_문자열;
//25 02 26

import java.util.*;
public class s2_03_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] s_Array = line.split(" ");

        int max = Integer.MIN_VALUE;

        String answer = "";

        for(String x:s_Array){
            if(x.length()>max){
                max=x.length();
                answer=x;
            }
        }
        System.out.println(answer);
    }
}
