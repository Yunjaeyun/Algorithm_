package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

public class s8_03_recursive {

    public static void main(String[]args){
        int n=5;
        int answer=factorial(n);
        System.out.println(answer);
    }
    private static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }
}
/*
이전문제들과 다르게 값이 쌓여야하네
 3
 3 * 2
 3 * 2 * 1

 2
 2 * 1

        private static void factorial(int n){
        if(){

        }else{
            n*fact(n-1)
        }
    }

  ☑️ △ miss 이유: n* fact(n-1)을 어떻게 다시 fact()에 넣지..? 라는 생각에ㅠ
            그러나 다시 보니, n*fact(n-1)을 넣는게 아니라 fact(n-1)만 넣잖아?!


 4 * f(3)
 5 *f(4)

   ✅포인트: 0!=1 생각하면 n==1이 아니라 n<=1이 정확.

   ✅피드백: 머릿속 생각을 텍스트로옮기자.
 */