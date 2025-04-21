package java_codingTest_study.section2_문자열.section2_R1;

import java.util.Scanner;

//250416
public class s2_11 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        String result = "";
        int i=0;

        while(i<len){
            char x = s.charAt(i);
            int cnt=1;

            while(i+1<len && x==s.charAt(i+1)){
                cnt++;
                i++;
            }
            i++;

            result+=x;
            result+=cnt;
        }
        result = result.replace("1", "");
        System.out.println(result);
    }
}
