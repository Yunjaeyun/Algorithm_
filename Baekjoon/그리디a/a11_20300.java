package Baekjoon.그리디a;
import java.util.*;
import java.lang.*;
//20240729
public class a11_20300 {
    public static void main(String[] args) {

        //오름차순 정렬 1 3 5 7 8 9
        //홀수 일 경우  1 3 5 7 8, 마지막 제외하고 처음+끝 -> 무한반복, 그중에서 젤 낮은값

        //짝수 일 경우, 처음+끝 -> 무한반복, 그중에서 젤 낮은값


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] fatigue = new long[num];

        for(int i=0; i<num;i++){
            fatigue[i] = sc.nextLong();
        }

        Arrays.sort(fatigue);
        long max_fatigue=0;

        if(num%2==0){ //짝수라면

            for(int i=0; i<num/2; i++){
                max_fatigue = Math.max(max_fatigue, fatigue[i] + fatigue[num-i - 1]);
            }



        }else { //홀수라면
            max_fatigue = fatigue[num - 1];
            for(int i=0; i<num/2; i++){
                max_fatigue = Math.max(max_fatigue, fatigue[i] + fatigue[num - 1 - 1 - i]);
            }

        }

        System.out.println(max_fatigue);

    }
}
