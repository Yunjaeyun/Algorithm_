package java_codingTest_study.section11_dp.section11_R2;

//25 03 24

import java.util.*;
public class s11_01_dp {
    static int [] arr;
    static int [] dis;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        dis = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.fill(dis,1);

        int answer = Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            int cur = arr[i];

            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dis[i] = Math.max(dis[i], dis[j] + 1);
                }
            }
            answer = Math.max(answer, dis[i]);
        }
        System.out.println(answer);
    }
}
/*
2, 7, 5, 8, 6, 4, 7, 12, 3


 */