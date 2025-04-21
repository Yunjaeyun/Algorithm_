package java_codingTest_study.section7_sort;
//2025 01 04 insertion sort


import java.util.Arrays;

/**

 n=5
 i=1
 j=1

 0 1
 [3,4,2,5,1]
 #

 n=5
 i=2
 j=2

  0 1 2
 [3,4,2,5,1]

 for i in range(1,n)
    for j in range(i)
        i-j vs i-j-1

 i=1    2 2
 j=0    0 1
 A=1    2 1
 */
public class s7_03_sorting {
    private int[] sorting(int[] arr){
        int n=arr.length;
        for(int i=1; i<n;i++){
            for (int j=0; j<i ; j++){
                if(arr[i-j-1] >arr[i-j] ){
                    int temp=arr[i-j];
                    arr[i-j]=arr[i-j-1];
                    arr[i-j-1]=temp;
                }else{
                    break;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        s7_03_sorting t = new s7_03_sorting();
        int[] arr = {3, 1, 2, 4, 5};
        System.out.println(Arrays.toString(t.sorting(arr)));
    }
}
