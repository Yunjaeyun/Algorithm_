package java_codingTest_study.section2_문자열.section2_R1;

import java.util.Scanner;

//250417
public class s2_08 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String re = "";

        for(char x:s.toCharArray()){
            if(Character.isLetter(x)) re+=x;
        }

        String reversed = new StringBuffer(re).reverse().toString();
        if(re.equalsIgnoreCase(reversed)) System.out.println("YES");
        else System.out.println("NO");
    }
}
