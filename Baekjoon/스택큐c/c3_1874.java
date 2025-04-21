package Baekjoon.스택c;
import java.util.*;
import java.lang.*;
import java.io.*;
//25 01 22
// pop으로 인해서, 쌓인 push값이 지워지면 다음 push를 쌓을수없음. 즉, 제3의 변수를 만드는것이 포인트
public class c3_1874 {
    private Stack<Integer> stack=new Stack<>();
    private List<Character> result = new LinkedList<>();

    private void func(int[] arr){

        int cur=1;
        for(int x:arr){

            while(cur<=x){
                stack.push(cur);
                result.add('+');
                cur++;
            }
            //같은 값이 될때까지 (어차피 x가 x-1 값보다 작으면, pop 순서임)

            if(x==stack.peek()){
                result.add('-');
                stack.pop();
            }else{
                System.out.println("NO");
                return;
            }
        }
        for(char x:result){
            System.out.println(x);
        }

    }




    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        c3_1874 t=new c3_1874();
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        t.func(arr);
    }
}
