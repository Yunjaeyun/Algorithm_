package java_codingTest_study.section2_문자열.section2_R1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//250415
public class s2_10 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();         // teachermode
        char t = sc.next().charAt(0); // e

        List<Integer> result = new ArrayList<>();

        int len = s.length();

        for(int i=0;i<len;i++){
            char x = s.charAt(i);
            int answer = Integer.MAX_VALUE;

            for(int j=0;j<len;j++){
                if(s.charAt(j)==t){
                    answer = Math.min(answer, Math.abs(i - j));
                }
            }
            result.add(answer);
        }
        for(int x:result) System.out.print(x+" ");
    }
}
