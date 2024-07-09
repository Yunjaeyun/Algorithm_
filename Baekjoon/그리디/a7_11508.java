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
//    세일 규칙 활용:
//
//        세 개를 묶을 때마다 가장 싼 상품이 무료가 되므로, 비싼 상품을 우선적으로 선택하여 할인받는 것이 유리합니다.
//
//
//        비싼 상품을 우선적으로 선택하는 것이 유리하다는 점을 이용하기 위해 가격을 내림차순으로 정렬합니다.
//        이렇게 하면 앞에서부터 세 개씩 묶을 때 항상 가장 작은 값이 무료가 되므로 할인 금액이 최대가 됩니다.