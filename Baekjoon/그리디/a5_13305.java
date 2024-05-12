//20240512
package Baekjoon.그리디;

import java.util.*;
import java.io.*;
import java.lang.*;

public class a5_13305 {
    public static void main(String[] args){

        //딱보니 경우의수case분류 문제
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] distance = new int[n - 1];
        for(int i=0; i<n-1; i++){
            distance[i]=sc.nextInt();
        }

        int[] price=new int[n];
        for (int i=0; i<n;i++){
            price[i]=sc.nextInt();
        }

        //    2      3      1
        //5 ---- 2 ---- 4 ---- 1

        //case1  첫주유소에서 다사용하는경우          5*2 + 5*3 + 5*1= 30 ----------------->
        //case2  첫주유소와 두번째주유소만 사용하는경우 5*2 + 2*3 + 2*1= 18 ----->----------->
        //case3  모든주유소 다 사용하는경우           5*2 + 2*3 + 4*1= 20 ----->----->----->

        //    3      3      4
        // 1 ---- 1 ---- 1 ---- 1

        //case1 첫주유소에서 다사용하는경우           1*3 + 1*3 + 1*4 =10
        //case2 첫주유소와 두번째주유소만 사용하는 경우 1*3 + 1*3 + 1*4 =10
        //case3 모든주유소 다 사용하는 경우           1*3 + 1*3 + 1*4 =10

        /*
        int expense[] = new int[n - 1];
        for (int i=0; i<n-1; i++){
            expense[i]=price[0]*
        }

         */

        // 이렇게 case분류하는게 틀렸다.
        // 반례 --->--------->--->----> 인 경우도 존재할것이다. 중간에 최솟값에 계속 갱신되는 경우..

        // 한번에 생각하지말고, 일단 거리 한칸씩 한칸씩 가다가(거리한칸*주유소한칸), 주유소가 더작은값이 나오면 바꿔서 계산,
        // 그러면 위와 같은 일정한 규칙으로 풀리지 않는다.
        int totalMin=0;
        int minPrice=price[0];



        for( int i=0; i<n-1; i++){
            if(price[i]<minPrice){
                minPrice=price[i];
            }
            totalMin+=(minPrice*distance[i]);
            //System.out.println("총 최소거리"+totalMin);

        }
        System.out.println(totalMin);


    }
}
/*
review
문제의 풀이법을 한정짓지 말것(ex case분류)
큰그림을 보는것도 좋지만 ,sum( 한칸 계산 -> 다음칸 계산 ... ) 이렇게 끊어서 계산할수도 있음.
 */