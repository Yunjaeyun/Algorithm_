package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

public class s8_02_recursive {
    public static void main(String[]args){
        int n=11;
        recursive(n);
    }
    private static void recursive(int n){
        if(n==0)return;
        else{
            recursive(n / 2);
            System.out.print(n % 2);

        }
    }
}
/*
11  / 2-> 5 ..1
5  / 2 -> 2 ..1
2 / 2 -> 1..0
1 / 2 -> 0..1
 */