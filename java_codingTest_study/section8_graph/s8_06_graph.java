package java_codingTest_study.section8_graph;
//25 02 08
import java.lang.*;
/*
1 2 3

3의 부분집합
   1    2    3
  o/x  o/x  o/x
        |
        v
    {       }

            1
          o   x
        2       2
      o   x   o    x
    3       3        3
  o   x   o   x   o      x
4       4      4          4
 */
public class s8_06_graph {

    static int n;
    static int []ch;

    private static void DFS(int L){

        if(L==n+1){
            String result="";
            for(int i=1;i<=n;i++) {
                if (ch[i]==1) result += (i + " ");
            }
            System.out.println(result);
        }else{
            ch[L]=1;
            DFS(L+ 1);
            ch[L]=0;
            DFS(L + 1);
        }


    }
    public static void main(String[]args){
        n=3;
        ch = new int[n+1];
        DFS(1);

    }
}
