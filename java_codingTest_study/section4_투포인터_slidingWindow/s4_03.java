package java_codingTest_study.section4_투포인터_slidingWindow;
//25 01 30
import java.util.*;
import java.lang.*;
public class s4_03 {


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(check(k,n,arr));
    }
    private static int check(int k,int n, int[]arr){
        int answer = 0;
        for (int i = 0; i < k; i++) answer += arr[i];

        int sum=answer;
        for(int i=k;i<n;i++){
            sum=sum+arr[i]-arr[i-k];
            answer=Math.max(sum,answer);
        }
        return answer;

    }
}
//10 3
// 12 15 11 20 25 10 20 19 13 15
/*
피드백
        for(int i=k;i<n;i++){
            int sum=answer+arr[i]-arr[i-k];
            answer=Math.max(sum,answer);
        }
       -> 최댓값 변수를 answer로 사용하고있다(ok)
          슬라이딩 윈도우의 합을 구하려면, 최댓값 vs  -cur[i-1] & cur[i] & cur[i+1] 구도로 가야함->그래야 올바르게 최댓값이 갱신되며 계산됨.
                        그러나 현재는   최댓값 vs   -cur[i-1] & 최댓값[i] & cur[i+1] -> 최댓값이 올바르게 갱신되지않음.(연속3칸 조건)
 */
