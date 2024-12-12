package Baekjoon.그리디a;

import java.util.*;
import java.lang.*;
//20240716 4.32

public class a9_11047 {
    public static void main(String[] args) {

        // 배열이 오름차순이니까,
        // 배열의 큰거부터 K값에 아귀가 맞는 숫자가 있나 for문 돈다
        // 아귀가 맞다면, 그 배열숫자로 나눈다 -> count +
        // k값을 재구성한다. 그 배열숫자로 나뉜 나머지로

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if(arr[i]<=k){
                count += k / arr[i];
                k %= arr[i];
            }
        }
        System.out.println(count);

    }
}
// 나머지? 4790 -> 4000 700 90
// 4000 700은 각 각 1000과 100으로 만든다쳐도, 90은 10 *9 가 아니라 50 + 10*4 라는 더 좋은 경우의 수가 존재한다.어떻게 해야할까
// 배열 인덱스 역순과 나머지계산을 이용한다!
