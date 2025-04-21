package java_codingTest_study.section6_스택큐.section6_R1;
//25 04 02

import java.util.*;
public class s6_07 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String required  = sc.next(); //CBA
        String plan = sc.next();

        Queue<Character> requiredQueue  = new ArrayDeque<>();

        for(char cur:required.toCharArray()) requiredQueue.offer(cur);

        for(char x:plan.toCharArray()){
            if(!requiredQueue.isEmpty() && x==requiredQueue.peek())
                requiredQueue.poll();
        }


        if(requiredQueue.isEmpty()) System.out.println("YES");
        else System.out.println("NO");

    }
}
