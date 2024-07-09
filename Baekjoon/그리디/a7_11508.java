package Baekjoon.그리디;
import java.util.*;
import java.io.*;
import java.lang.*;
//20240709 0712
public class a7_11508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Integer[] arr = new Integer[num];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());


        int sum=0;
        for(int i=0; i<arr.length; i++){

            if((i+1)%3==0){ //0부터 인덱스 시작하기때문
            }else{
                sum += arr[i];
            }
        }
        System.out.println(sum);

    }
}
