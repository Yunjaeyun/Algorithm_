//20240510
package Baekjoon.그리디;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a3_2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        String[] parse=line.split(" ");

        int N= Integer.parseInt(parse[0]);
        int M= Integer.parseInt(parse[1]);

        int j=sc.nextInt();
/*
        List<Integer> list=new ArrayList<>();

        for (int i=0; i<j; i++){
            int x=sc.nextInt();
            list.add(x);
        }

        int sum=0;
        if(j==1){
            System.out.println(Math.abs(1- list.get(0)));
            System.exit(0);
        }

        for(int i=0; i<j-1;i++){ // j=3 , i= 0 16
            if(M==1){
                int a=list.get(i)-list.get(i+1); // [0]-[1] + [1]-[2]
                sum=sum+Math.abs(a);
            }else{
                int a=list.get(i)-list.get(i+1);
                sum=sum+Math.abs(a)-(M-1);
            }
        }
        System.out.println(sum);


 */
        /*
        review
        처음엔 감이 안잡혔다. 노트에 손으로 그림을 그리고 솔류션을 봤더니
        감이 잡혔다.(물론 솔루션대로 풀지는 않았다.)
        abs(좌표-좌표) + abs(좌표-좌표) + abs(좌표-좌표)
        단 M이 1이 아니라, 바구니칸 2개칸(etc e,4...)을 차지하는 큰 바구니라면 원래칸 수 인 1보다 추가된 칸수만큼(1)을 빼야한다.
        쉽게 생각하면 바구니칸이 2개라면, N칸의 스크린이 아니라, N-1칸으로 줄여서 생각하면된다.


        반례)
        5 1
        1
        3
        떨어지는 사과가 한개일 경우도 고려

        반례가 많아서 이 코드로 해결할수없다. 바구니가 이동할 필요가 없을때, 즉 가만히 있어도 사과를 받을수있는 경우
        두가지(바구니 왼쪽, 바구니 오른쪽)를 해결하기 위해 솔루션을 통해 코드를 재구성했다.


        솔루션: 이런 무언가를 옮기는 문제는
        바구니의 크기에 따라 맨 처음을 start, 마지막을 end로 좌표처럼 설정하고 움직인 만큼 좌표 이동시킨다.
        세가지 case를 분류한다.
        1. 사과가 바구니 왼쪽에 떨어질경우    ->distance=사과떨어진 왼쪽좌표-start
        2. 사과가 바구니 오른쪽에 떨어질경우      -> distance=사과떨어진 오른쪽좌표-end
        3. 사과가 떨어지는데 바구니를 이동할 필요가 없는경우 -> distance=0

        3번케이스( a<x<b)를 제일 먼저 검사해야한다. 1번이나 2번에서(a<x)(x<b) 먼저실행하면 if 문을 먹어버릴수도 있다.
         */

        int start=1;
        int end=M;
        int distance=0;
        for (int i=0; i<j; i++){
            int applePosition=sc.nextInt();

            if(start<applePosition && applePosition<end ) { //바                                                                                                                                                                                                                                                                                                                                                                                                             구니 이동할필요가 없이 사과가 담기는 경우
                //pass
                continue;

            }else if(end<applePosition){ //바구니 우측에 사과 떨어짐  -->

                int move=applePosition-end;

                start+=move;
                end+=move;
                distance+=move;
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                System.out.println("distance = " + distance);

             }else if(applePosition<start){ //바구니 좌측에 사과 떨어짐  <--

                int move=start-applePosition;

                start-=move;
                end-=move;
                distance+=move;
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                System.out.println("distance = " + distance);
             }

        }
        System.out.println(distance);
    }
}
/*
start+=(drop-end);
end+=(drop-end);

distance+=Math.abs(drop-end);
end의 값이 바뀌면서, distance의 end에도 영향을 주었음(주면안됨) -> 해결: 맨앞에 두기
 */