package java_codingTest_study.section2_문자열;
//25 02 28

import java.util.*;
public class s2_09_string {

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        String line = sc.next().toLowerCase();

        line = line.replaceAll("[^0-9]", "");


        int a = Integer.parseInt(line);
        System.out.println(a);



    }
}
