package java_codingTest_study.section2_문자열.section2_R1;
//25 04 15

import java.util.Scanner;

public class s2_02 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String result= "";
        for(char x:s.toCharArray()){
            if(Character.isLowerCase(x)) result+= Character.toUpperCase(x);
            else result += Character.toLowerCase(x);
        }
        System.out.println(result);

    }
}
