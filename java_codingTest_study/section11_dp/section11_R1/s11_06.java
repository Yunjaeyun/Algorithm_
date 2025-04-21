package java_codingTest_study.section11_dp.section11_R1;
//25 03 13

import java.util.*;
public class s11_06 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] dy=new int[m+1];
        dy[0]=0;

        for(int i=0;i<n;i++){
            int score = sc.nextInt();
            int time = sc.nextInt();

            for(int j=m;j>=time;j--){
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }
        System.out.println(dy[m]);


    }
}
