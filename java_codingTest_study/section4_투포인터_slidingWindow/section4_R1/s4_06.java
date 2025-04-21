package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 26

import java.util.*;
public class s4_06 {
    static int n, k;
    static int []arr;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         k = sc.nextInt();
         arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sol();
    }
    private static void sol(){
        int len=0,rt=0,lt=0,cnt=0;
        for(rt=0;rt<n;rt++){
            if(arr[rt]==1) cnt++;
            

        }

    }
}
