package java_codingTest_study.section5_해시;
//25 01 30
import java.util.*;
import java.lang.*;
public class s5_02_해시 {



    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();

        System.out.println(check(x, y));
    }

    // {'A':1,'B':2}
    // {'A':2,'B':2}
    private static String check(String first, String second) {
        Map<Character, Integer> dict1 = new HashMap<>();
        Map<Character, Integer> dict2 = new HashMap<>();

        for (char x : first.toCharArray()) { // 'A'
            if (dict1.containsKey(x)) {
//                int cur_count= dict1.get(x);
//                cur_count= cur_count+1;
//                dict1.put(x,cur_count);

                dict1.put(x, dict1.get(x) + 1);
            } else {
                dict1.put(x, 1);
            }
        }
//        List<Map.Entry<Character, Integer>> sorted_dict1 = new ArrayList<>(dict1.entrySet());
//        sorted_dict1.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        for (char x : second.toCharArray()) { // 'A'
            if (dict2.containsKey(x)) {
//                int cur_count= dict2.get(x);
//                cur_count= cur_count+1;
//                dict2.put(x,cur_count);

                dict2.put(x, dict2.get(x) + 1);
            } else {
                dict2.put(x, 1);
            }
        }
//        List<Map.Entry<Character, Integer>> sorted_dict2 = new ArrayList<>(dict2.entrySet());
//        sorted_dict2.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        if (dict1.equals(dict2)) return "YES";
        else return "NO";
    }
}
