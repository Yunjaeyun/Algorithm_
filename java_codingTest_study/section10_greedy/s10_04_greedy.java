package java_codingTest_study.section10_greedy;
//25 02 20

import java.util.*;

class Lecture implements Comparable<Lecture>{
    int money,time;
    Lecture(int m, int t){
        this.money = m;
        this.time = t;
    }
    @Override
    public int compareTo(Lecture other){
        return other.time - this.time;
    }
}
public class s10_04_greedy {
    static List<Lecture> arr;
    static Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); //원래 PriorityQueue는 최소값을 뽑아낸다. reverse로 최댓값뽑게 바꾸자.
    static int answer=0;
    private static void solution(List<Lecture> arr, int n){
        arr.sort(null);
        int max=arr.get(0).time;
        int x=0;
        for(int i=max;i>=1;i--){
            for(;x<n;x++){
                if(arr.get(x).time<i)break;
                q.offer(arr.get(x).money);
            }
            if(!q.isEmpty()) answer += q.poll();

        }

    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int money = sc.nextInt();
            int time = sc.nextInt();
            arr.add(new Lecture(money, time));
        }
        solution(arr, n);

        System.out.println(answer);
    }
}
//while문으로도 풀어볼것
/*
for (int i = max; i >= 1; i--) {
    // 현재 날짜 i에 배정 가능한 강의(즉, deadline이 i 이상인 강의)를 모두 추가
    while (j < n && arr.get(j).time >= i) {
        pQ.offer(arr.get(j).money);
        j++;
    }
    if (!pQ.isEmpty()) {
        answer += pQ.poll();
    }
}

 */