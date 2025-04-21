package java_codingTest_study.section5_해시.section5_R1;
//25 03 30

import java.util.*;
public class s5_02 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(sol(a, b));
    }
    private static String sol(String a,String b){
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();

        for(char x:a.toCharArray()){
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);

        }

        for(char x:b.toCharArray()){
            mapB.put(x, mapB.getOrDefault(x, 0) + 1);

        }



        if(mapA.equals(mapB)) return "YES";
        else return "NO";
    }
}
