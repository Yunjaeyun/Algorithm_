package java_codingTest_study.section5_해시.section5_R2;
//25 04 11

import java.util.*;
public class s5_01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x:s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println(arr.get(0).getKey());
    }
}
