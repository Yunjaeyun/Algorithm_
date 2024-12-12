//20240511
package Baekjoon.그리디a;
import java.util.*;
import java.lang.*;
public class a4_2217 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int weight = sc.nextInt();
//
//            list.add(weight * n);
//        }
//        System.out.println(Collections.min(list));
        //예제1 pass

/*
반례
3
10 -> 20
15 -> 30
20 -> 40

1)3개다 모두 사용시 ->최대20

2) 일부사용시
15와 20중량을 들수있는것만 쓰면-> 최대30(택)

문제를 풀다보니 하나씩 하나씩 로프를 선택해가며 경우의 수가 늘어났다.
case 분류를 해야겠다는 생각이 들었다. 2828번처럼


4
10
15
20
30

1)4개다 모두 사용시 ->최대40
10 -> 10*  4 40
15 -> 15 * 4 60
20 -> 40 * 4 160
30 -> 60 * 4 240

2)3개 선택시(최대한 중량을 많이 버틸수있는것을 선택, 나머지는 볼필요없음)\
10

15 15*3 45
20 20*3 60
30 30*3 90  =>45

3)2개 선택시
10
15

20 40  --> 40
30 60

4)1개 선택시
10 10*1=10 <<--(?? 얘를 선택하면 틀림)
15
20
30 30*1=30

     */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] ropes=new int[n];

        for (int i=0; i<n; i++){
            int weight=sc.nextInt();

            ropes[i]=weight;
        }

        Arrays.sort(ropes);

        int [] result=new int [n];
        for( int i=0; i<n; i++){
            // 로프 1개 선택시 result[0]= ropes[3]* 1   의미: 젤큰 중량 1개 로프 택하여 그중에 젤 작은값
            // 로프 2개 선택시 result[1]= ropes[2]* 2   의미: 젤큰 중량 2개 로프 택하여 그중에 젤 작은값
            // 로그 3개 선택시 result[2]= ropes[1]* 3   의미: 젤큰 중량 3개 로프 택하여 그중에 젤 작은값
            // 로프 4개 선택시 reuslt[3]= ropes[0]* 4   의미: 다 선택하므로 , 선택된 로프로 들수있는 중량은 가장 적은 중량을 들수있는 로프

            result[i]=ropes[n-(i+1)]*(i+1);
        }
        int max=result[0];
        for(int data: result){
            if(data>max)
                max=data;
        }
        System.out.println(max);
    }
}
/*
review
내림차순으로 case를 짜서 헷갈렸나?
풀고보니 이렇게까지 오래걸릴 문제는 아니였다.
case 분류-> 코드구성
이 연습이 더 필요할듯하다.

 */