package Baekjoon.그리디a;
import java.util.*;
import java.lang.*;

//20240713
/*
1. 한줄 입력받을때
2.개행문자소비
 */
public class a8_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();



        int[] arr=new int[num];
        for(int i=0; i< num;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum=0;
        int total=0;
        for(int i=0; i<num;i++){
            sum += arr[i];
            total += sum;
        }
        System.out.println(total);





    }
}

// 앞에 있는 수를 반드시 누적해야한다.
// 큰수부터 누적되면 최대값이. 작은수부터 누적되면 최솟값이 나올것이다.
//인덱스는 고려사항이 아님