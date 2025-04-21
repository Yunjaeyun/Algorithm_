package java_codingTest_study.section9_graph.section9_R1;
//25 03 034

import java.util.*;
public class s9_01_graph {
    static String answer = "NO";
    static int total=0;
    static int n;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int []arr = new int[n+1];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            total+=arr[i];
        }

        DFS(0, 0,arr);

        System.out.println(answer);

    }
    private static void DFS(int L, int sum, int[]arr){
        if(sum>total/2) return;
        if(L==n){
            if(total-sum==sum){
                answer = "YES";
                return;
            }
        }else{
            DFS(L + 1, sum + arr[L],arr);
            DFS(L + 1, sum, arr);
        }
    }
}



/*
☑️ 사고흐름 따라가기
집합문제네
{1, 3, 5, 6, 7, 10}
   ⬇
  {  } 1 이 O or x
       3 이 o or x

      dfs로 내려가면서 그러다가 전체집합의 절반값이 될수 있겠네

 ☑️ DFS() 호출 횟수차이 .pdf
 */