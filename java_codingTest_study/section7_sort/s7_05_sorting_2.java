package java_codingTest_study.section7_sort;

import java.util.Arrays;
import java.util.Scanner;

public class s7_05_sorting_2 {
    private String sorting(int n, int [] arr){
        Arrays.sort(arr);
        for (int i=0; i<n;i++){
            if(arr[i]==arr[i+1]){ // 중복존재
                return "D";
            }
        }
        return "U";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        s7_05_sorting_2 t=new s7_05_sorting_2();
        String answer=t.sorting(n,arr);
        System.out.println(answer);
    }
}
