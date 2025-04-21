package java_codingTest_study.section11_dp.section11_R1;
//25 03 11

import java.util.*;
public class s11_03_dp {
    static int[]arr,dis;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        dis = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.fill(dis, 1);

        int result=0;

        for(int i=1;i<n;i++){

            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dis[i] = Math.max(dis[i], dis[j] + 1);
                }
            }
            result = Math.max(result, dis[i]);

        }
        System.out.println(result);



    }
}
