package java_codingTest_study.section2_문자열;
//25 02 28

import java.util.*;
public class s2_10_string_마지막출력에조건설정법 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char t = sc.next().charAt(0);


        int[] answer = new int[s.length()];

        int cnt=1000;
        for (int i = 0; i < answer.length;i++ ) {
            if(s.charAt(i)==t) {
                answer[i] = 0;
                cnt = 0;
            }
            else{
                answer[i]=++cnt;
            }
        }

        cnt=1000;
        for (int i = answer.length-1; i >=0;i-- ) {
            if(s.charAt(i)==t) {
                answer[i] = 0;
                cnt = 0;
            }
            else{
                answer[i]=Math.min(answer[i],++cnt);
            }
        }
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]);
            if(i<answer.length-1) System.out.print(" ");
        }
    }
}
// 문자 t를 발견한뒤로는 ++코드가 맞지만, 그전까지는 아님.ex) avsadwaa w
// 문자 t를 발견하기전까지는 매우큰값을 넣자. 나중에 min메서드가 처리해줄것임.