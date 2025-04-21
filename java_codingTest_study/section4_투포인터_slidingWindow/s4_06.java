package java_codingTest_study.section4_투포인터_slidingWindow;
//25 02 01
import java.util.*;
import java.lang.*;

public class s4_06 {



    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n;i++)arr[i]=sc.nextInt();

        int rt=0,lt=0, cnt=0, len=0;
        int max=0;

        for(rt=0;rt<n;rt++){

            if(arr[rt]==1) {


            }
            else { // 어쨌든 0->1로 바꿀꺼잖아
                if(cnt>= k){
                    while(arr[lt]!=0){
                        lt++;
                    }
                    cnt-=1;
                    lt++;
                    cnt++; //**

                }else{ //change 0->1
                    cnt++;
                }
            }
            len=rt-lt+1;            //
            max=Math.max(len,max); //* change point: loop out
        }
        System.out.println(max);
    }
}
