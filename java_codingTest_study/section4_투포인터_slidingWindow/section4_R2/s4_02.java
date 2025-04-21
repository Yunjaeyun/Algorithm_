package java_codingTest_study.section4_투포인터_slidingWindow.section4_R2;
//25 04 03

import java.util.*;
public class s4_02 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        sol(arr1, arr2, n, m);
    }
    private static void sol(int[]arr1, int[]arr2, int n, int m){
        List<Integer> result = new ArrayList<>();
        int rt=0;int lt=0;
        while(rt<n && lt<m){
            if(arr1[rt]<arr2[lt]) rt++;
            else if(arr2[lt]<arr1[rt]) lt++;
            else if(arr1[rt]==arr2[lt]) {
                result.add(arr1[rt]);
                rt++; lt++;
            }
        }
        for(int x:result) System.out.print(x+" ");
    }
}
