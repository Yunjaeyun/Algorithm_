package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_02_recursive {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursive(n);
    }

    private static void recursive(int n){
        if(n==0){
            return;
        }else{
            recursive(n / 2);
            System.out.println(n % 2);
        }
    }
}
/*
11 /2 -> 5..1
5 /2 -> 2..1
2/2 -> 1..0
1/2 -> 1..1

d(1/2) ->2로 나눈 나머지
d(2/2)
d(5/2)
d(11/2)


 */