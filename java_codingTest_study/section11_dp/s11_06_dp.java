package java_codingTest_study.section11_dp;
//25 02 25

import java.util.*;
public class s11_06_dp {
    static int[]dy;
    static int n, m;
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dy = new int[m + 1];

        for (int i = 0;i<n;i++){
            int ps = sc.nextInt();
            int pt = sc.nextInt();

            for(int j=m; j>=pt;j--){
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);

            }
        }
        System.out.println(dy[m]);
    }
}
