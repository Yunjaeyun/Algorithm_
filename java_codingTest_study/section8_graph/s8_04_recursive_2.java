package java_codingTest_study.section8_graph;

public class s8_04_recursive_2 {
    static int[] fibo;
    private int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return  fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else  return fibo[n]=DFS(n-2)+DFS(n-1);
    }

    public static void main(String[] args) {
        s8_04_recursive_2 t=new s8_04_recursive_2();
        int n=10;
        fibo=new int[n+1];
        t.DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");

    }
}
