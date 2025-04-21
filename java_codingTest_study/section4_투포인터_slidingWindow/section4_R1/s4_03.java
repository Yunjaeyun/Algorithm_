package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 26

import java.util.*;
public class s4_03 {
    static int []arr;
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }


        int sum=0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        int winsum=sum;

        //k=3 i=3 want 0
        //k=3 i=4 want 1
        for(int i=k;i<n;i++){
            winsum = winsum + arr[i] - arr[i - k];
            sum = Math.max(sum, winsum);
        }

        System.out.println(sum);
    }
}
