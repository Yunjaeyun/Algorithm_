package java_codingTest_study.section2_문자열.section2_R1;
//25 04 15

import java.util.*;
public class s2_01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        char t = Character.toLowerCase(sc.next().charAt(0));
        int cnt=0;
        for(char x:s.toCharArray()){
            if (x==t) cnt++;
        }
        System.out.println(cnt);

    }
}
