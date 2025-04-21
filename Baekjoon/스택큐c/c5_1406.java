package Baekjoon.스택c;
import java.util.*;
import java.lang.*;
import java.io.*;

//25 01 25
public class c5_1406 {


    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack=new Stack<>();
        Stack<Character> rightStack=new Stack<>();

        String s=br.readLine();
        int n= Integer.parseInt(br.readLine());
        for (char x:s.toCharArray()) leftStack.push(x);

        while(n>0){
            String cmd = br.readLine();

            switch(cmd.charAt(0)){
                case 'P':
                    leftStack.push(cmd.charAt(2));
                    break;
                case 'L':
                    if(!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(!leftStack.isEmpty())
                        leftStack.pop();

            }
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for(char x:leftStack) sb.append(x);
        while(!rightStack.isEmpty()) sb.append(rightStack.pop());

        System.out.println(sb);





    }
}
