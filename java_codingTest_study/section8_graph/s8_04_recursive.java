package java_codingTest_study.section8_graph;
/*
3

 */
public class s8_04_recursive {
    private int DFS(int n){
        if(n==1 || n==2 ){
            return 1;
        }
        else{
            return DFS(n-1) + DFS(n-2);
        }
    }

    public static void main(String[] args) {
        s8_04_recursive t=new s8_04_recursive();
        int n=10;
        for(int i=1; i<= n; i++) System.out.print(t.DFS(i)+" ");
    }
}
