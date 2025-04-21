package java_codingTest_study.section4_투포인터_slidingWindow;
//25 02 01
import java.util.*;
import java.lang.*;
public class s4_05 {


    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=i+1;

        System.out.println(check(arr,n));
    }
    private static int check(int[]arr, int n){
        int lt=0,rt=0,count=0,sum=0;
        for( rt=0;rt<n;rt++){
            sum+=arr[rt]; //
            if(sum==n) count++;
            else if(sum>n){
                while(sum>n){
                    sum-=arr[lt++];
                    if(sum==n && rt-lt>=1) count++; //[15]도 count될수있다는 문제해결, 문제조건은 두개이상 숫자 필요로했음.
                }
            }
        }
        return count;


    }
}
