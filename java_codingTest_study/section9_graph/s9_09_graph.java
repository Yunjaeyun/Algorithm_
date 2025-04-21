package java_codingTest_study.section9_graph;
//25 02 17
import java.util.*;
public class s9_09_graph {
    static int n,m;
    static int []cm;
    private static void DFS(int L, int s){
        System.out.println("L:" + L + ", s:" + s);
        if(L==m){
            for(int x:cm) System.out.print(x + " ");
            System.out.println();
            System.out.println();
        }else{
            for(int i=s;i<=n;i++){
                cm[L]=i;
                DFS(L + 1, i+1);
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        cm = new int[m];
        DFS(0,1);
    }
}
