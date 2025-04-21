package java_codingTest_study.section8_graph.section8_R1;
//25.03.03

import java.util.*;
public class s8_01_recursive {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        recursive(3);
    }

    private static void recursive(int n){
        if(n==0) return;
        else{
            recursive(n - 1);
            System.out.print(n + " ");
        }
    }
}
/*
△ Miss 이유: 재귀는 스택(후입선출)을 사용하는 자료구조임을 생각하고 풀자.
            스택이 쌓이는 과정을 머릿속으로 그림을 그려볼것.

 */