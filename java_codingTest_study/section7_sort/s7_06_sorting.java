package java_codingTest_study.section7_sort;

import java.util.Arrays;
import java.util.Scanner;

//2025 01 04
public class s7_06_sorting {
    private void sorting(int n, int[] arr){
        int arr_1[]=arr; //정렬안됨  120 125 152 130 135 135 143 127 160

        int[] arr_2=Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr_2);
                        //정렬됨    120 125 127 130 135 135 143 152 160


        int arr_1_index=0;
        int arr_2_index=0;

        while (arr_1_index<arr_1.length && arr_2_index < arr_2.length){
            //문제 없으면 둘다 index+1
            if(arr_1[arr_1_index]==arr_2[arr_2_index]){
                arr_1_index+=1;
                arr_2_index+=1;


            }
            //문제 있으면,
            else{
                System.out.print((arr_2_index+1)+" ");
                arr_1_index+=1;
                arr_2_index+=1;
            }
        }





    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        s7_06_sorting t=new s7_06_sorting();
        t.sorting(n,arr);
    }
}
