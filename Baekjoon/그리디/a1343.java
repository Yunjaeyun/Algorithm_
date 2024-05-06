package Baekjoon.그리디;

import java.util.Scanner;
//20240506
public class a1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

/*      9:40
        String A = "AAAA";
        String B = "BB";

        //예제1
        if((A+B).length()==next.length()){
            System.out.println(A+B); //A,B 안됨
        }

        //예제2
        // split구현 생각했으나, 위코드로 예제 1,2를 동시에 구현하기어려움 느낌->답지

        //힌트: XXXX AAAA  XX BB로 치환


 */    //9:52


/*
        //시도1
        for (int i=0; i<next.length();i++){
            //next[i:i+3] 자바에서 사용불가, substring사용
            if(next.substring(i,i+3)==XXXX){
                String substring = next.substring(i, i + 3);
                substring = XXXX;
            }
        }

        //point 1: == --> String비교시 equals
        //point 2: indexoutRange오류 -> for문의 end를 3만큼 줄이자.
        //point 3: substring은 부분문자열을 반환하기만 할뿐, 수정할수없음
        for(int i=0; i<next.length()-3; i++){
            if(next.substring(i,i+4).equals(XXXX)){
                String substring = next.substring(i, i + 4);
                substring = XXXX;
            }else if(next.substring(i,i+2).equals(XX)){
                String substring = next.substring(i, i + 2);
                substring = XXXX;
            }
        }
        System.out.println(next);

 */
        String XXXX = "AAAA";
        String XX = "BB";

        //시도2
        String RESULT = next.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
        //System.out.println(RESULT);

        if(RESULT.contains("X")){ // next검사가 아닌 -> result 검사
            System.out.println(-1);
        }else{
            System.out.println(RESULT);
        }


    }
}
/*
review
처음에 드는 생각은 AAAA BB 이 두조각을
입력되는 XXXXXX에 각각 가능한한 배정시키면 되겠다고 생각함.
배정시키기 위해서 substring을 사용했지만 indexout에러가 남.
치환을 통해 조각을 배정시켜서 풀수있음을 알게됨.

 */
