package java_codingTest_study.section4_투포인터_slidingWindow.section4_R1;
//25 03 25

import java.util.*;
public class s4_01 {
    static int[] a;
    static int[]b;

    static int n,m;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();

        a=new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

         m = sc.nextInt();
        b = new int[m];
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        sol();
    }
    private static void sol(){
        int p1=0;
        int p2=0;

        while(p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else if(a[p1]>b[p2]) answer.add(b[p2++]);
            else {
                answer.add(a[p1++]);
                answer.add(b[p2++]);

            }

        }
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(answer);


        if(p1>=n){ //p1이 끝
            for(int i=p2;i<m;i++){
                answer.add(b[i]);
            }
        }

        if(p2>=m){ //p2가 끝
            for(int i=p1;i<n;i++){
                answer.add(a[i]);
            }

        }
        System.out.println(answer);

    }
}
