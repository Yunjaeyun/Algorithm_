package java_codingTest_study.section7_sort;

import java.util.Arrays;
import java.util.Scanner;

//2024 01 04

/**

  # 뒤로 밀리는 부분 구현? c[i] = c[i-1]
  # 제3의 변수에 값 저장

 */
public class s7_04_sorting {
    private int[] sorting(int size, int n,int [] arr){        // arr [1,2,3,2,6,2,3,5,7]
        int[] cache = new int[size]; // 0 0 0 0 0
        for(int x:arr) {
            int pos=-1;
            // 중복 있는지 검사 ->  Cache Miss or Cache Hit 판단하기 위해
            for(int i=0;i<size;i++){
                if(x==cache[i]) pos=i;
            }

            //Cache Miss
            if(pos==-1){ //중복없음.
                for(int i=size-1; i>0;i--){
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
//               1 0 0 0 0
//               2 1 0 0 0
//               3 2 1 0 0


            }else{
                for(int i=pos; i>0;i--){
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
            }

        }


        return cache;
    }


    public static void main(String[] args) {
        s7_04_sorting t=new s7_04_sorting();
        Scanner sc = new Scanner(System.in);
        int s=sc.nextInt();
        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(Arrays.toString(t.sorting(s,n,arr)));
    }
}
