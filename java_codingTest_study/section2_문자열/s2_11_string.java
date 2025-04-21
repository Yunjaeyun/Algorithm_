package java_codingTest_study.section2_문자열;
//25 02 28

import java.util.*;
public class s2_11_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();

        int cnt=1;

        String result = "";

        int i=0;

        for(i=0;i<s.length-1;i++){
            if(s[i]==s[i+1]) cnt++;
            else{

                if(cnt>1) result += (s[i] + String.valueOf(cnt));
                else result += s[i];


                cnt=1;
            }
        }
        if(cnt>1) result+=(s[i]+String.valueOf(cnt));
        else result += s[s.length-1];
        System.out.println(result);
    }
}

//마지막에 if/else처리 보단. 입력받는 string에 +" "을 하는게 더좋을듯.
//stringbuilder로 메모리 할당도 줄이고