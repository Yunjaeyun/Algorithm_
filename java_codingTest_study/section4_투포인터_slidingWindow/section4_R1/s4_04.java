package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 26

import java.util.*;
public class s4_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int rt=0,lt=0;
        int sum=0;
        int cnt=0;

        for( rt=0;rt<n;rt++){
            sum += arr[rt];
            if(sum==m) cnt++;
            if(sum>=m){
                while(sum>=m){
                    sum -= arr[lt++];
                    if(sum==m) cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
