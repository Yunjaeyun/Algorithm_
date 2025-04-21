package java_codingTest_study.section11_dp.section11_R2;
//25 03 24

import java.util.Scanner;

public class s11_06_dp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m + 1];

        for(int i=0;i<n;i++){
            int score = sc.nextInt();
            int time = sc.nextInt();

            for(int j=m;j>=time;j--){
                arr[j] = Math.max(arr[j], arr[j - time] + score);
            }
        }
        System.out.println(arr[m]);
    }
}
// 인덱스를 주어진시간이라고 생각하셈.제한시간말고