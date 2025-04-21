package java_codingTest_study.section2_문자열.section2_R1;

import java.util.Scanner;

//250415
public class s2_09 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String result = "";
        for(char x:s.toCharArray()){
            if(Character.isDigit(x)) result += x;
        }
        System.out.println(Integer.valueOf(result));
    }
}
