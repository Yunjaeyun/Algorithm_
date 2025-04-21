package java_codingTest_study.section5_해시.section5_R2;

import java.util.*;
import java.util.Scanner;

public class s5_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String line = sc.next();//bacaAacba
        String s = sc.next();   //abc

        HashMap<Character, Integer> ing_map = new HashMap<>();
        HashMap<Character, Integer> crz_map = new HashMap<>();

        for(char x:s.toCharArray()){
            crz_map.put(x, crz_map.getOrDefault(x, 0) + 1);
        }

        int k = s.length();
        int result=0;

        int cnt=0;
        for(char x:line.toCharArray()){
            ing_map.put(x, ing_map.getOrDefault(x, 0) + 1);
            cnt++;
            if(cnt==k) break;
        }
        if(ing_map.equals(crz_map)) result++;

        for(int i=k;i<line.length();i++){ // i3 k3
            ing_map.put(line.charAt(i), ing_map.getOrDefault(line.charAt(i), 0) + 1);
            int value=ing_map.get(line.charAt(i - k)); // map.get('a')
            ing_map.put(line.charAt(i - k), value - 1);
            if(value-1==0) ing_map.remove(line.charAt(i - k));

            if(ing_map.equals(crz_map)) result++;
        }
        System.out.println(result);


    }
}
/*
len 3
3 4 5
0 1 2
3 3 3
 */