package Baekjoon;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 바구니의 길이 N과 화면의 길이 M 입력
        int N = sc.nextInt(); // 바구니의 길이
        int M = sc.nextInt(); // 화면의 길이

        // 사과의 개수 J 입력
        int J = sc.nextInt(); // 사과의 개수

        // 초기 바구니의 시작과 끝 위치
        int start = 1;
        int end = M;
        int distance = 0;

        // 각 사과의 떨어지는 위치에 따라 처리
        for (int i = 0; i < J; i++) {
            int applePosition = sc.nextInt(); // 사과의 떨어지는 위치

            if (applePosition >= start && applePosition <= end) {
                // 사과가 바구니 안에 떨어지는 경우 (이동 거리 없음)
                continue;
            } else if (applePosition > end) {
                // 사과가 바구니 우측에 떨어지는 경우
                int moveDistance = applePosition - end; // 이동해야 할 거리 계산
                distance += moveDistance; // 이동 거리 추가
                start += moveDistance; // 바구니 시작 위치 업데이트
                end += moveDistance; // 바구니 끝 위치 업데이트
            } else if (applePosition < start) {
                // 사과가 바구니 좌측에 떨어지는 경우
                int moveDistance = start - applePosition; // 이동해야 할 거리 계산
                distance += moveDistance; // 이동 거리 추가
                end -= moveDistance; // 바구니 끝 위치 업데이트
                start -= moveDistance; // 바구니 시작 위치 업데이트
            }
        }

        // 결과 출력
        System.out.println(distance);

        sc.close();
    }
}
