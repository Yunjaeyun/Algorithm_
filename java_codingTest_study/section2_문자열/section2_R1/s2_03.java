package java_codingTest_study.section2_문자열.section2_R1;
//25 04 15

import java.util.*;
public class s2_03 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String max="";
        int max_length=0;

        String s = sc.nextLine();
        String[] tokens = s.split(" ");

        for(String cur:tokens){
            if(cur.length()>max_length){
                max_length=cur.length();
                max=cur;
            }
        }
        System.out.println(max);
    }
}
