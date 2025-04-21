package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
public class s9_01_graph {
    static int[]arr;
    static int total=0;
    static String answer = "NO";
    static boolean flag=false;
    static int n;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0,0);
        System.out.println(answer);

    }
    private static void DFS(int L,int sum){
        if(L==n)return; //*
        if(flag) return;
        if((total/2)<sum)return;
        if((total/2)==sum){
            answer = "YES";
            flag=true;
            return;

        }else{
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
/*
경우의수 문제네 dfs
각 단계에서 해당원소를 선택할지 말지 가지치기 하면서, 나간다.
제3의 변수 sum을 사용해 if문과 함께 처리하자.
if문에서 sum은 total/2=sum일때
                       d(0)
                     ㅇ/1   \x
                    d(1,1)   d(1,0)
                   /ㅇ 3 x\
                 d(2,4)   d(2,1)
                 /ㅇ 5 \x
               d(3,9)  d(3,4)
              /o 6 x\
                   d(4,9)
                   /o 7 \x
                  d(5,16)

 */