package java_codingTest_study.section4_투포인터_slidingWindow.section4_R2;
//25 04 08

import java.util.*;
public class s4_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //8
        int m = sc.nextInt(); //6 target

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int sum=0;
        int cnt=0;
        int rt=0;
        int lt=0;

        for(int i=rt;i<n;i++){
            sum += arr[i];
            if(sum==m)cnt++;
            while(sum>=m){

                sum -= arr[lt++];
                if(sum==m) cnt++;
            }
        }
        System.out.println(cnt);



    }
}
