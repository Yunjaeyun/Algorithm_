package java_codingTest_study.section8_graph;
//2024 12 24

/**

 1
 1

 2
 1 2

 3
 1 2 3

 */
public class s8_01_recursive {

    private void recursive(int n){
        if(n==0) return;
        else{
            recursive(n-1);
            System.out.print(n+" ");
        }

    }
    public static void main(String[] args) {
        s8_01_recursive t=new s8_01_recursive();
        t.recursive(5);
    }
}
