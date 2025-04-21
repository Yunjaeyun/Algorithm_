package java_codingTest_study.section5_해시;

import java.util.*;
import java.lang.*;

//25 01 30
public class s5_02_해시_깔끔 {


    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();

        System.out.println(check(x, y));
    }
    private static String check(String first,String second){
        Map<Character,Integer> dict1=buildFreqMap(first);
        Map<Character,Integer> dict2=buildFreqMap(second);

        if(dict1.equals(dict2)) return "YES";
        return "NO";
    }

    private static Map<Character,Integer> buildFreqMap(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char x:s.toCharArray()){
            int y = freqMap.getOrDefault(x, 0) + 1;
            freqMap.put(x, y);
        }
        return freqMap;
    }

}
