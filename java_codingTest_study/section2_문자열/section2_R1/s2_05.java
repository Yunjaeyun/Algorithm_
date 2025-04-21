package java_codingTest_study.section2_문자열.section2_R1;

import java.util.Arrays;
import java.util.Scanner;

//25 04 15
public class s2_05 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int lt=0;
        int rt=s.length()-1;

        char[] arr = s.toCharArray();
        while(lt<rt){
            if(!Character.isLetter(arr[lt])) lt++;
            else if(!Character.isLetter(arr[rt])) rt--;
            else{ // lt rt
                char tmp=arr[lt];
                arr[lt] = arr[rt];
                arr[rt]=tmp;

                lt++;
                rt--;
            }
        }
        for(char x:arr) System.out.print(x);



    }
}
/*
0  2
10 10
9  7


a#b!GE*T@

 */