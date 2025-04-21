package java_codingTest_study.section9_graph.section9_R2;
//25 03 16
import java.util.*;
public class s9_06_graph {
    static int n,m;
    static int arr[];
    static int[]ch;
    static int[]pm;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        arr=new int[n+1];
        ch = new int[n+1];
        pm = new int[m];

        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        DFS(0);
    }
    private static void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i]=0;
                }
            }
        }
    }
}


/*
            d(0)
            /3|6\9
           d(1)
           /3|6\9
          d(2)

d(2)             3 6
d(1) i=2 ->[3 6] 1 2 3
d(0) i=1 ->[3 ]  1 1

 */