package java_codingTest_study.section5_해시.section5_R2;
//25 04 11

import java.util.*;
public class s5_02 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char x:a.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        for(char x:b.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        if(map1.equals(map2)) System.out.println("YES");
        else System.out.println("NO");
    }
}
