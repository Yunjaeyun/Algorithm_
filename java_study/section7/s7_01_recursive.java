package java_study.section7;
//2024 12 24

/**

 1
 1

 2
 1 2

 3
 1 2 3

 */
public class s7_01 {

    private void recursive(int n){
        if(n==0) return;
        else{
            recursive(n-1);
            System.out.print(n+" ");
        }

    }
    public static void main(String[] args) {
        s7_01 t=new s7_01();
        t.recursive(5);
    }
}
