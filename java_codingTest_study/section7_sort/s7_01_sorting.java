package java_codingTest_study.section7_sort;
//2024 01 04 sat

/**
 3  1  2

 n=3
 i=0
 j=3
  0 1 2
 [1,3,2]
  #

 n=3
 i=1
 j=2

    1 2
 [1,2,3]
    #
 for i in range(n-1){
    min_idx=i
    for j in range(n-i){
        if arr[i+j]<arr[min_idx]{
            min_idx=i+j
        }
    #자리교체 i 와 min_index
    int temp=arr[i];
    arr[i]=arr[min_index]
    arr[min_index]=arr[temp]
    }
    #i+j vs i
 }
 */

public class s7_01_sorting {
    private int[] sorting(int []arr){
        int n=arr.length;
            for(int i=0; i<n-1; i++){
                int min_index=i;
                for (int j=0;j<n-i;j++){
                    if(arr[i+j]<arr[min_index]){
                        min_index=i+j;
                    }
                }
                int temp=arr[i];
                arr[i]=arr[min_index];
                arr[min_index]=temp; // temp값은 idx가 아닌 arr값임. 인덱싱 처리하면안됨arr[min_index]=arr[temp]; (x)
            }
        return arr;
    }
    public static void main(String[] args) {
        s7_01_sorting t=new s7_01_sorting();
        int []question ={3,1,4,2,5};
        System.out.println(t.sorting(question));
    }
}
