package java_codingTest_study.section2_문자열.section2_R1;
//25 04 15

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class s2_06 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Set<Character> set = new LinkedHashSet<>();
        for(char x:s.toCharArray()) set.add(x);

        for(char x:set) System.out.print(x);
    }
}
