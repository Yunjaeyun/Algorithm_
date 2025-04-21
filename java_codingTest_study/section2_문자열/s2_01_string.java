package java_codingTest_study.section2_문자열;
//25 02 25

import java.util.*;
public class s2_01_string {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        char check = sc.next().charAt(0);

        check = Character.toLowerCase(check);

        int answer=0;
        for (char x : line.toCharArray()) {
            char re_x = Character.toLowerCase(x);
            if(re_x==check) answer++;
        }
        System.out.println(answer);
    }
}
