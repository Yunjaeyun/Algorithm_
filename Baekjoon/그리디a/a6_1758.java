package Baekjoon.그리디a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//20240702 3:#35
public class a6_1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Integer numbers[] = new Integer[num];

        for (int i = 0; i < num; i++) {
            numbers[i] = sc.nextInt();
        }


        Arrays.sort(numbers, Collections.reverseOrder());
        int order=0;
        long sum=0;
        for(int number: numbers){
            ++order;

            int result= number - (order - 1);
            if(result>0)
                sum += result;

        }
        System.out.println(sum);

    }
}
//큰수가 뒤로가면 손실이 커져서 안된다.

//    문제의 조건을 다시 보면, 팁을 주려는 사람의 수(N)는 최대 100,000이고, 각 사람이 주려고 하는 팁은 최대 100,000입니다.
//    최악의 경우, 모든 사람이 최대 팁을 주려고 한다고 가정해보겠습니다.
//
//        이 경우, 총 팁의 합은 다음과 같이 계산될 수 있습니다:
//
//        최대팁의최대합
//      100,000×100,000=10,000,000,000
//
//        이 값은 int 자료형의 최대값인 2,147,483,647를 초과합니다.
//        따라서, int 자료형을 사용하면 오버플로우가 발생할 수 있습니다.
//        하지만, long 자료형을 사용하면 충분히 큰 값을 저장할 수 있으므로 오버플로우 문제를 방지할 수 있습니다.