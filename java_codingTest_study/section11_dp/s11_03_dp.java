package java_codingTest_study.section11_dp;
//25 02 24

import java.util.*;
public class s11_03_dp { // 5 3 7 8 6 2 9 4

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(sol(arr));
    }
    private static int sol(int[]arr){
        int []dy=new int[arr.length];
        int answer=0;

        Arrays.fill(dy, 1);

        for(int i=1;i<arr.length;i++){

            for(int j=i-1; j>=0; j--){
                if( arr[i] > arr[j])
                    dy[i] = Math.max(dy[i], dy[j] + 1);
            }
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
