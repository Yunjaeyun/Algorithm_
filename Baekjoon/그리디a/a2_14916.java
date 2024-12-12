package Baekjoon.그리디a;
//20240507
import java.util.Scanner;

public class a2_14916 {
    public static void main(String[] args) {
        //5:55 그냥 나머지 %로 풀면될것같은데?
        /*
        int count=0;
        Scanner sc = new Scanner(System.in);
        int q=sc.nextInt();
        while(q>0){
            q=q-5;
            count+=1;
        }
        while(q>0){
            q=q-2;
            count+=1;
        }
        System.out.println(count);



        try2
        //5원 계산한 후의값을  x라고 하면, x는 2원으로만 처리되어야하므로 2의배수여야한다. 즉, -5계산후값이 2의배수여야만 -5계산을 한다.
        //6:04

        38=5*7 +...  (x)
        -> 5*6 + 2*4

        더 정확히 하자면, 5x 로 나눠진 나머지가 2의배수일 경우를 찾아야한다.

        int count=0;
        Scanner sc = new Scanner(System.in);
        int q=sc.nextInt();
        while(q>0){
            if((q-5)%2==0) {
                q = q - 5;
                count += 1;
            }
        }
        while(q>0){
            q=q-2;
            count+=1;
        }
        System.out.println(count);

         */


        // 6:31
        // try3 :더 정확히 하자면, 5x 로 나눠진 나머지가 2의배수일 경우 찾기
        // 근데 처음부터 5씩 나눠서계산하면 , 계산과정 중간에서 계산값이 2의배수가되어 2의배수계산으로 넘어갈수도잇음

        // 즉, x>0 조건을 만족하는, 거꾸로 5로 나눌수있는 최대값을 찾고 거기서부터 -1해서 찾자.
        // point1) 실제로 값을 나누면서 계산하지말기, back이 안되니까 .

        int count=0;
        Scanner sc = new Scanner(System.in);
        int q=sc.nextInt();

        if(q==1||q==3) {
            System.out.println(-1);
            System.exit(0);
        }
        count=count+ (q/5); // 13 /5=2     13-(5*1)

        while (q>0){
            if((q-(5*count))%2==0) {
                q = q - (5 * count);
                break;
            }
            count-=1;
        }
        count+=q/2;
        System.out.println(count);


    }
    //거슬러줄수없는경우? 1, 3,
}
/*
review
try1
긴 막대원통을 생각하고, 입구에서 큰수를 하나떨어뜨린다고 상상하자. 그리고 조건에 맞게 필터링한다.

try2
z=5x+2y 다항식을 생각했다.
(*point1)그런데 13의 경우 우선순위를 생각해, x=2를 대입해버리면 나머지값이 2로나눠떨어지질않아 계산이 올바르지 못하는 문제가 발생한다.
->해결: 나눌수있는 최대값 x 를 구한다. z= 5*최대값 + 2y 가 성립되는지, 즉 z-5*최댓값=2y , z-5*최대값이 2의배수가 되는지 확인한다.
안되면 될때까지 최대값-=1를 진행한다.
 */
