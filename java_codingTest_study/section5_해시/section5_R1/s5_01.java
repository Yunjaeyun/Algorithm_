package java_codingTest_study.section5_해시.section5_R1;
//25 03 30

import java.util.*;
public class s5_01 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String vote = sc.next();
        sol(vote);

    }
    private static void sol(String vote){
        Map<Character, Integer> map = new HashMap<>();
        for(char x:vote.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println(mapList.get(0).getKey());
    }
}
