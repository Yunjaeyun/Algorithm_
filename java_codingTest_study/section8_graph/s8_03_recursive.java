package java_codingTest_study.section8_graph;
//2024 12 24

/*
5!
5=5*4*3*2*1
4=4*3*2*1
3=3*2*1
2=2*1
1=1
 */
public class s8_03_recursive {

    private int recursive3(int n){
        if (n<=1) return 1;
        else{
            return n* recursive3(n-1);

        }
    }

    public static void main(String[] args) {
        int result;
        s8_03_recursive t=new s8_03_recursive();
        result=t.recursive3(5);
        System.out.println(result);
    }
}
