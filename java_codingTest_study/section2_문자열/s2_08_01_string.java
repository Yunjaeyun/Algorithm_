package java_codingTest_study.section2_문자열;
//25 02 27

import java.util.*;
public class s2_08_01_string {
// found7, time: study; Yduts; emit, 7Dnuof
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();

        int lt=0;
        int rt = line.length() - 1;

        char[] s = line.toCharArray();

        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])){
                lt++;
            }else if(!Character.isAlphabetic(s[rt])){
                rt--;
            }else if(s[rt]==s[lt]){

                lt++;
                rt--;
            }
            else{//서로다르면 return NO
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
