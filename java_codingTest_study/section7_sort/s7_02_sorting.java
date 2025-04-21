package java_codingTest_study.section7_sort;

import java.util.Scanner;

//2025 01 04 bubblesort

/**
 n=3
 i=0
 j=2
  0 1 2
 [2,3,1]
 [2,1,3]
      #

 n=3
 i=1
 j=1
  0 1
 [1,2,3]
    # #

for i in range(n-1)
    for j in range(n-i):
        j vs j+1
 */
public class s7_02_sorting {
    private int[] sorting(int n, int []arr){
        for (int i=0; i<n-1;i++){
            for (int j=0;j<n-1;j++ ){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k=sc.nextInt();
        int arr[]=new int[k];
        for(int i=0; i<k; i++) arr[i]=sc.nextInt();

        s7_02_sorting t=new s7_02_sorting();
        for(int x:t.sorting(k,arr)) System.out.print(x+" ");


    }
}
