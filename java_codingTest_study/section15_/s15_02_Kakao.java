package java_codingTest_study.section15_;
//25 06 30

import java.util.*;
public class s15_02_Kakao {


    public static void main(String[] args) {
        String input = "abcabcabcabcdededededede";

        System.out.println("정답=14 현재풀이값= "+stringCompression(input)); // 14가 출력되어야 합니다!
        System.out.println("정답 = 3 / 현재 풀이 값 = " + stringCompression("JAAA"));
        System.out.println("정답 = 9 / 현재 풀이 값 = " + stringCompression("AZAAAZDWAAA"));
        System.out.println("정답 = 12 / 현재 풀이 값 = " + stringCompression("BBAABAAADABBBD"));
    }

    public static Integer stringCompression(String string) {

        int result=Integer.MAX_VALUE;

//        System.out.println(string.length());
        if (string.length()==1) return 1;

        for(int split_size=1;split_size<=string.length()/2;split_size++){

            // abcdef6 6

            List<String> arr = new ArrayList<>();
            for(int i=0;i<string.length();i=i+split_size){
                if(i+split_size<=string.length()) {
                    arr.add(string.substring(i, i + split_size));
                }else{
                    arr.add(string.substring(i, string.length()));
                }
            }

//            System.out.println("splited is" + arr);
            StringBuilder sb = new StringBuilder();
            int cnt=1;

            for(int j=0;j<arr.size();j++){

                if(j+1<arr.size() && arr.get(j).equals(arr.get(j+1))) {
                    cnt++;
                }else {
                    if(cnt>1) sb.append(cnt);
                    sb.append(arr.get(j));

                    cnt=1;
                }
            }
            String s = sb.toString();
//            System.out.println("string:"+s);
            result = Math.min(result, s.length());
        }
        return result;

    }
}
/*
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder("");
        int cnt=1;

        for(int i=0;i<s.length();i++){

            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) {
                cnt++;
            }else {
                sb.append(cnt +""+s.charAt(i));
                cnt=1;
            }
        }
        System.out.println(sb);
        return null; // 아직 구현되지 않음
 */