package java_codingTest_study.section4_투포인터_slidingWindow.section4_R2;
//25 04 03

import java.util.*;
public class s4_03 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //10
        int k = sc.nextInt(); //3

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int max_3_days=0;
        for (int i = 0; i < k; i++) {
            max_3_days += arr[i];
        }


        int answer=max_3_days;

        for(int i=k;i<n;i++){
            int new_3_Days = max_3_days + arr[i] - arr[i - k];

            answer = Math.max(answer, new_3_Days);
            max_3_days=new_3_Days;
        }
        System.out.println(answer);

    }
}
/*
3 4 5
3 3 3
0 1 2
 */