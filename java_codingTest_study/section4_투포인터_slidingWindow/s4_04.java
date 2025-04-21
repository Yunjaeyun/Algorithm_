package java_codingTest_study.section4_투포인터_slidingWindow;
import java.util.*;
import java.lang.*;

//25 02 01
public class s4_04 {


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(); int k=sc.nextInt();
        int []arr=new int[n];
        for(int i=0; i<n;i++) arr[i]=sc.nextInt();

        System.out.println(check(arr,n,k));
    }
//8 6
//
// 1 2 1 3 1 1 1 2
    private static int check(int[]arr, int n, int k){
        int lt=0,count=0,sum=0;

        for(int rt=0;rt<n;rt++){
            sum += arr[rt];
            if (sum==k) {
                count++;
            }
            else if(sum>k){ // 1 2 1 3 1 1 1 1 2
                while(sum>k){
                    sum-=arr[lt++];
                    if (sum==k) count++;
                }
            }


        }
        return count;
    }


}
