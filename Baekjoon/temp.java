package Baekjoon;

import java.util.*;

public class temp {
    static int[] visited = new int[100_001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 시작 위치
        int k = sc.nextInt(); // 목표 위치

        bfs(n, k);

        System.out.println(minTime);
        System.out.println(count);
    }

    private static void bfs(int start, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1; // 시작 시간은 0초지만 visited 배열에는 +1로 저장

        while (!q.isEmpty()) {
            int now = q.poll();

            int time = visited[now];

            if (now == target) {
                if (time - 1 < minTime) {
                    minTime = time - 1;
                    count = 1;
                } else if (time - 1 == minTime) {
                    count++;
                }
                continue;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next <= 100_000) {
                    // 아직 방문하지 않았거나 같은 시간에 도착 가능하면 계속 진행
                    if (visited[next] == 0 || visited[next] == time + 1) {
                        visited[next] = time + 1;
                        q.offer(next);
                    }
                }
            }
        }
    }
}
