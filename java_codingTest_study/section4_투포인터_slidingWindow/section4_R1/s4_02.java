package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 25

import java.util.*;
public class s4_02 {
    static int[]a;
    static int[]b;

    static int n, m;

    static List<Integer> result = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        m = sc.nextInt();
        b = new int[m];

        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int p1=0;
        int p2=0;


        while(p1<n && p2<m){
            if(a[p1]==b[p2]) {
                result.add(a[p1]);
                p1++;p2++;
            }
            else if(a[p1]<b[p2]) p1++;
            else if(a[p1]>b[p2]) p2++;
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(result);

        for(int x:result) System.out.print(x + " ");

    }
}
