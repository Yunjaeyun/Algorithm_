package java_codingTest_study.section5_해시.section5_R1;
//25 03 30

import java.util.*;
public class s5_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); //bacaAacba
        String t = sc.next();

        int n = s.length(); //9
        int len = t.length(); //3
        int cnt=0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x:t.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        HashMap<Character, Integer> result = new HashMap<>();
        for(int i=0;i<len;i++){
            result.put(s.charAt(i),result.getOrDefault(s.charAt(i),0)+1);

            if(map.equals(result)) cnt++;
        }


        for(int i=len;i<n;i++){
            result.put(s.charAt(i), result.getOrDefault(s.charAt(i), 0) + 1);
            result.put(s.charAt(i - len), result.get(s.charAt(i - len)) - 1);
            if(result.get(s.charAt(i-len))==0) result.remove(s.charAt(i - len));

            if(map.equals(result)) cnt++;
        }
        System.out.println(cnt);

    }
}
/*
3 4 5   8
3 3 3   3
0 1 2   5
 */