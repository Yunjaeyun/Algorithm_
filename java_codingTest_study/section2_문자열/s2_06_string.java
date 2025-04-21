package java_codingTest_study.section2_문자열;
//25 02 07

import java.util.*;
public class s2_06_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String line = sc.next();

        Set<Character> set = new LinkedHashSet<>();

        for(char x:line.toCharArray()){
            set.add(x);
        }

        String answer = "";
        for(char x:set){
            answer+=x;
        }

        System.out.println(answer);
    }
}
