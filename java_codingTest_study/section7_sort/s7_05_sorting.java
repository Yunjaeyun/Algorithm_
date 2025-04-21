package java_codingTest_study.section7_sort;
//2025 01 04

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 */
public class s7_05_sorting {
    private void sorting(int[] arr){
        int origin_len=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int x:arr){
            set.add(x);
        }
        if(set.size()==origin_len) { //모두 다름
            System.out.println("U");
        }else{
            System.out.println("D");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        s7_05_sorting t=new s7_05_sorting();
        t.sorting(arr);
    }
}
