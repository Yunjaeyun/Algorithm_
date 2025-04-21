package java_codingTest_study.section2_문자열;
//25 02 25

import java.util.*;
public class s2_02_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        for(char x:line.toCharArray()){
              if(Character.isUpperCase(x)){
                  x = Character.toLowerCase(x);
              }else if(Character.isLowerCase(x)){
                  x = Character.toUpperCase(x);
              }
            System.out.print(x);
        }
    }
}
// strinbuilder에 담아도될듯