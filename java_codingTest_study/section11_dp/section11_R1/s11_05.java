package java_codingTest_study.section11_dp.section11_R1;
//25 03 13

import java.util.*;
public class s11_05 {
    static int coin[];
    static int dy[];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        coin = new int[n];
        for(int i=0;i<n;i++){
            coin[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE); //*
        dy[0]=0; //*

        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=m;j++){
                dy[j]=Math.min(dy[j],dy[j-coin[i]]+1 );
            }
        }
        System.out.println(dy[m]);
    }
}
