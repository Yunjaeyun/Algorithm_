package java_codingTest_study.section5_해시.section5_R1;
//25 03 30

import java.util.*;
public class s5_05 {
    public static void main(String []args){ // 중복회피
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(sol(n, k, arr));
    }
    private static int sol(int n,int k, int[]arr){ //10 3
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int p=j+1;p<n;p++){
                    tSet.add(arr[i] + arr[j] + arr[p]);
                }
            }
        }
        int cnt=1;
        int answer=-1;

        for(int x:tSet){
            if(cnt==k) return x;
            cnt++;
        }
        return -1;
    }

}
