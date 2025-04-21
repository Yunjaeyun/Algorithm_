package java_codingTest_study.section2_문자열;

import java.util.*;

public class s2_12_string {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String line = sc.next();

        line = line.replace("*", "0").replace("#", "1");

        List<String> arr = new ArrayList<>();
        for(int i=0;i<line.length();i++){ //7 0-6

            if((i+1)%7==0) arr.add((line.substring(i - 6, i+1)));
        }
//        System.out.println(arr);

        for(String x:arr){
            int n = Integer.parseInt(x, 2);
//            System.out.println(n);
            System.out.print((char)n);

        }




    }
}
