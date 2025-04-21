package java_codingTest_study.section5_해시;
// 딩코 Hash 3rd 예제
//25 01 27

import java.util.*;
/*
all_students = ["나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"]
present_students = ["정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"]
 */
public class s5_00_programmers_hash {
    private static String check(List<String> all_students,List<String> present_students){
        HashSet<String> set=new HashSet<>();
        for(String each_key:all_students){
            set.add(each_key);
        }
        for(String each_present:present_students){
            set.remove(each_present);
        }
        for(String result:set){
            return result;
        }

        return "";
    }


    public static void main(String[]args){
        List<String> all_students = Arrays.asList("나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위");
        List<String> present_students = Arrays.asList("정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현");

        String answer=check(all_students, present_students);
        System.out.println(answer);
    }
}
