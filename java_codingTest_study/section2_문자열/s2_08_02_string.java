package java_codingTest_study.section2_문자열;
import java.util.*;

public class s2_08_02_string {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().toUpperCase();


        line=line.replaceAll("[^A-Z]", "");

        String sb = new StringBuilder(line).reverse().toString();

        if(line.equals(sb)) System.out.println("YES");
        else System.out.println("NO");
    }
}
