package java_codingTest_study.section7_sort;
import java.util.*;
import java.lang.*;


//2024 12 22
public class s7_07_binarySearch {

    public int solution(int n,int m , int[]arr){
        int answer=0;
        int current_min=0;
        int current_max=n-1;

        int current_guess=(current_max+current_min)/2;


        Arrays.sort(arr);

        while (current_min<=current_max){
            //up down game - 성공
            if (arr[current_guess]==m) {
                answer=current_guess+1;
                break;
            }
            if(arr[current_guess]<m){
                current_min=current_guess+1;
            }
            else{
                current_max=current_guess-1;
            }

            current_guess=(current_max+current_min)/2;

        }

        return answer;

    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt(); //N 길이
        int m = in.nextInt(); //M 타겟
        int[] arr=new int[n];

        for (int i=0; i<n;i++){
            arr[i]=in.nextInt();
        }
        s7_07_binarySearch T=new s7_07_binarySearch();
        int result = T.solution(n, m, arr);
        System.out.println(result);


    }
}
