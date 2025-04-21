package java_codingTest_study.section9_graph.section9_R1;
//25 03 05

import java.util.*;
public class s9_06_graph {
    static int n,m;
    static int[]pm,arr,ch;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        ch = new int[n];
        pm=new int[m];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        DFS(0);

    }
    private static void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
}
/*
                    D(0,0)
         / 3            |6       9\
        D(1,3)          D(1,6) D(1,9)
      /   |    \
        D(2,6) D(2,9)
ch
012

arr
012
369

pm이라는 배열을 시험장에서 떠올리는 사고흐름.
중복을 허용하지않으니, check[]배열로 visited처리를 해야겠다.이정도?
 */