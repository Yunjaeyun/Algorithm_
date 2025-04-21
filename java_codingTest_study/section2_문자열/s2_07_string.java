package java_codingTest_study.section2_문자열;
//25 02 27
import java.util.*;
public class s2_07_string {
    static String answer = "YES";
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String line = sc.next().toLowerCase();

        sol(line);
        System.out.println(answer);
    }
    private static void sol(String line){
        int lt=0;
        int rt=line.length()-1;

        char[] s = line.toCharArray();
        while(lt<rt){
            if(s[lt]!=s[rt]) {
                answer= "NO";
                return;
            }

            else {
                lt++;
                rt--;
            }
        }
    }
}
