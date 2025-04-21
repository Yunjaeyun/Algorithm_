package java_codingTest_study.section4_투포인터_slidingWindow.section4_R2;
//25 04 08

import java.util.*;
public class s4_05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = n / 2 + 1;

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = i+1;


        int sum=0; int lt=0; int cnt=0;
        for(int i=0;i<len;i++){
            sum += arr[i];
            if(sum==n) cnt++;
            while(sum>=n){

                sum-=arr[lt++];
                if(sum==n) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
