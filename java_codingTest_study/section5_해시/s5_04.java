package java_codingTest_study.section5_해시;
import java.util.*;
//25 02 02
/*

{'a':0}
 */
public class s5_04 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();

        System.out.println(func(s, t));
    }
    private static int func(String s,String t){
        int cnt=0;

        int k=t.length(); //3
        Map<Character,Integer> dict1= new HashMap<>();
        Map<Character,Integer> dict2= new HashMap<>();

        for(int i=0;i<k-1;i++){
            int z = dict1.getOrDefault(s.charAt(i), 0);
            dict1.put(s.charAt(i), z + 1);
        } //{'b':1,'a':1}
//        System.out.println(dict1);

        for(int i=0; i<k;i++){
            int y = dict2.getOrDefault(t.charAt(i), 0);
            dict2.put(t.charAt(i), y + 1);
        } //  {'a':1,   'b':1,  'c':1}
//        System.out.println(dict2);

        // k=3, k-1=2 , s.len=9
        // rt lt
        int rt=0,lt=0;
        for(rt=k-1;rt<s.length();rt++){
            int a=dict1.getOrDefault(s.charAt(rt),0);
            dict1.put(s.charAt(rt), a+1);
            if(dict1.equals(dict2)) cnt++;

            /**삭제
             * 소멸되는 경우도 생각*/
            int x = dict1.get(s.charAt(lt));
            x-=1;
            dict1.put(s.charAt(lt), x);
            if(x==0) dict1.remove(s.charAt(lt));

            lt++;
        }
        return cnt;
    }
}
