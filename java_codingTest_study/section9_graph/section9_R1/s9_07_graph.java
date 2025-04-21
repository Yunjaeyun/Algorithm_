package java_codingTest_study.section9_graph.section9_R1;
//25 03 05
import java.util.*;
public class s9_07_graph {
    static int memo[][];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        memo = new int[n + 1][n + 1];

        System.out.println(DFS(n, r));
    }
    private static int DFS(int n,int r){
        if(memo[n][r]!=0) return memo[n][r];
        if(n==r || r==0) return 1;
        else{
            return memo[n][r]=DFS(n - 1, r - 1)+DFS(n - 1, r);
        }
    }
}
/*
    5C3
    {1,2,3,4,5}

    { }
5C3은 4C2+4C3이다.
왜냐? 5을 넣는다고 가정했을때
5을 넣어서 숫자3개를 뽑는경우의수- > 4c2
5을 안넣고 숫자3를   뽑는 경우의수-> 4c3

     5c3
    4c2
   3c1
  2c0 2c1

 */