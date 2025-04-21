package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 26

import java.util.*;
public class s4_05 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int N = n / 2 + 1;
        int rt=0,lt=0,sum=0,cnt=0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;

        for(rt=0;rt<N;rt++){
            sum += arr[rt];
            if(sum==n) cnt++;
            if(sum>=n){
                while(sum>=n){
                    sum -= arr[lt++];
                    if(sum==n) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
