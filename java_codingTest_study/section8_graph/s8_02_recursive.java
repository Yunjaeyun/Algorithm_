package java_codingTest_study.section8_graph;
//2024 12 24

/**

 11 % 2= 5 ...1
 5  % 2= 2 ...1
 2  % 2= 1 ...0
1   % 2= 0 ...1
 */
public class s8_02_recursive {
    private void recursive2(int n){
        if(n<1) return;
        else{
            recursive2(n/2);
            System.out.print(n%2);

        }

    }
    public static void main(String[] args) {
        s8_02_recursive t=new s8_02_recursive();
        t.recursive2(11);
    }
}
