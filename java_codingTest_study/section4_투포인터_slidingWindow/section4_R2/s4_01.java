package java_codingTest_study.section4_투포인터_slidingWindow.section4_R2;
//25 04 03

import java.util.*;
public class s4_01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

        sol(arr,arr2,n,m );
    }
    private static void sol(int[]arr, int[]arr2, int n,int m){
        List<Integer> result = new ArrayList<>();
        int rt=0;
        int lt=0;

        while(rt<n && lt<m){
            if(arr[rt]<arr2[lt]){
                result.add(arr[rt++]);

            }else if(arr2[lt]<arr[rt]){
                result.add(arr2[lt++]);

            }else{ //동일시
                result.add(arr[rt++]);
                result.add(arr2[lt++]);
            }
        }
        while(rt<n){
            result.add(arr[rt++]);
        }
        while(lt<m){
            result.add(arr2[lt++]);
        }
        for(int x:result) System.out.print(x + " ");



    }
}
