package java_codingTest_study.section2_문자열;
//25 02 27

import java.util.*;
public class s2_05_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String line = sc.next();

        int lt=0;
        int rt = line.length()-1;

        char[] s = line.toCharArray();

        while(lt<rt){
            if(!Character.isLetter(s[lt]))
                lt++;

            else if(!Character.isLetter(s[rt]))
                rt--;

            else{
                char tmp = s[rt];
                s[rt] = s[lt];
                s[lt]=tmp;

                lt++;
                rt--;
            }
        }
        System.out.println(s);

    }
}
//* rt lt 위치