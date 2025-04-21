package java_codingTest_study.section4_투포인터_slidingWindow;
import java.util.*;
import java.lang.*;

public class s4_06_깔끔하게 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


        func(arr, n, k);
    }

    private static void func(int[]arr, int n, int k){
        int rt = 0, lt = 0, countZero = 0;
        int maxLen = 0;

        for(rt=0;rt<n;rt++){

            if(arr[rt]==0){
                countZero++;
            }

            while(countZero>k){
                if(arr[lt]==0){
                    countZero--;
                }
                lt++;
            } //6-2+1

            maxLen = Math.max(maxLen, rt - lt + 1);

        }
    }
}
