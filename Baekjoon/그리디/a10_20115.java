package Baekjoon.그리디;
import java.util.*;
import java.io.*;
import java.lang.*;
//20240722

public class a10_20115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[num];
        for (int i=0; i<num;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        double sum = 0;
        for(int  i=0; i<num-1;i++){
            sum += (double)arr[i] / 2.0;
//            System.out.println(sum);
        }
        System.out.println(arr[num-1]+sum);

    }
}
