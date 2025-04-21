package java_codingTest_study.section5_해시.section5_R2;
//25 04 11

import java.util.*;
public class s5_05 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int q=j+1;q<n;q++){
                    ts.add(arr[i] + arr[j] + arr[q]);
                }
            }
        }
        int result=-1;

        int cnt=0;
        for(int x:ts){
            if(cnt== k-1) result=x;
            cnt++;
        }
        System.out.println(result);
    }
}
