package java_codingTest_study.section10_greedy.section10_R2;
//25 03 24

import java.util.*;
class Meet implements Comparable<Meet>{
    int start, end;
    Meet(int s, int e){
        this.start=s;
        this.end=e;
    }
    @Override
    public int compareTo(Meet other){
        if(this.end==other.end) return this.start-this.end;
        else return this.end-other.end;
    }
}
public class s10_02_greedy {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Meet> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Meet(s, e));
        }

        arr.sort(null);

        int end=arr.get(0).end;

        int answer=1;

        for(int i=0;i<n;i++){
            if(end<=arr.get(i).start){
                end=arr.get(i).end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
/*
 1      4
   2  3
      3    5
        4     6
           5     7


 1s +1
 2s +1
 아.. 결혼식문제처럼은 안풀리겠구나. 이런식이면 1 4회의가 무조권 참여했다는게 되버림.

핵심은 끝나는시간<=시작시간

2 3
1 4
3 5
4 6
5 7
최대로 회의실을 많이 쓸려면 빨리 "끝내야함"
끝내는 시간을 기준으로 정렬.
끝내는시간<=시작시간인거 찾으셈.

1 3
3 3
3 4
피드백 적용!-> class내의 두값을 정렬 후 비교 하는게 관건인 문제인경우, 정렬되는 값이
같을경우를 처리해야한다.
 */