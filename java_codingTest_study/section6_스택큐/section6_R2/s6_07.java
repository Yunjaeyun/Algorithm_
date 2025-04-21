package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
public class s6_07 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String m = sc.next();

        System.out.println(SOL(s, m));

    }

    private static String SOL(String s, String m) {
        Queue<Character> needQ = new ArrayDeque<>();

        for(char x: s.toCharArray()) needQ.offer(x);
        for(char x: m.toCharArray()){
            if(needQ.contains(x)){ //필수과목이라면
                if(x!=needQ.poll())  return "NO";
            }
        }
        if(!needQ.isEmpty()) return "NO";
        else return "YES";
    }
}
