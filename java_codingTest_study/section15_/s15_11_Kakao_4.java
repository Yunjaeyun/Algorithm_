package java_codingTest_study.section15_;
//25 07 16

import java.util.*;
// 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
//만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환

public class s15_11_Kakao_4 {


    public static void main(String[]args){
        // [+,-,*]-> 순열로 가능한 경우 index 계산

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solution(s);


    }

    static Set<Character> set = new LinkedHashSet<>();


    static char[] ops_set;

    static List<Character> opList = new ArrayList<>();
    static List<Long> numList = new ArrayList<>();

    static int arr[];
    static boolean visited[];

    private static long solution(String s){


        for(char x:s.toCharArray()){
            if(!Character.isDigit(x)) set.add(x);
        }

        // get 쓸수있도록 배열로
         ops_set = new char[set.size()];

        int idx=0;
        for(char x: set){
            ops_set[idx++]=x; // *-+ 중복 처리한거
        }

        // 200*300-500+20
        // 이젠 중복처리 안된 연산자 , 숫자리스트 만들기
        StringBuilder sb = new StringBuilder();
        for(char x:s.toCharArray()){
            if(Character.isDigit(x)){
                sb.append(x);
            }else{
                numList.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                opList.add(x);
            }
        }
        numList.add(Long.parseLong(sb.toString()));


        arr=new int[ops_set.length];
        visited = new boolean[ops_set.length];

        permutation_dfs(0);
        return (max);
    }

    static long max=0;

    private static void permutation_dfs(int L){ // s 200*300-500+20 *-+
        if(L== ops_set.length){ //arr
//            for(int i = 0; i< ops_set.length; i++){
//                System.out.print(arr[i]);
//            }
//            System.out.println();

            max = Math.max(max, evaluate(arr));


        }else{
            for(int i = 0; i< ops_set.length; i++){
                if(!visited[i]){
                    arr[L]=i;
                    visited[i]=true;
                    permutation_dfs(L+1);
                    visited[i]=false;

                }

            }
        }
    }
                                             //             0 1 2 3 4 5 6
    private static long evaluate(int []arr){ // 012 , ops= 200*300-500+20
        List<Character> opsNow = new ArrayList<>(opList);
        List<Long> nums = new ArrayList<>(numList);

                                            //       nums=  200 300 500 20
        for(int idx:arr){                    //       op  =  *   -   +
            char c = ops_set[idx]; //ops[0] => '-'           0   1   2   3

            for(int i = 0; i< opsNow.size(); ){
                if(c==opsNow.get(i)){
                    long numA=nums.get(i);
                    long numB=nums.get(i+1);

                    long res=calc(numA,numB, c);

                    nums.remove(i);
                    nums.set(i , res);
                    opsNow.remove(i);
                }else{
                    i++;
                }
            }

        }
        return Math.abs(nums.get(0));
    }

    private static long calc(long a, long b, char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return 0;
    }
}
/*
for(i = 1 2 3
            L
          d(0)
         1/ 2| 3\
        d(1)
      1/ 2| 3\
     d(2)
  1/ 2| 3\
        d(3)


         1  2  3
visit =[ v , ,   ]
 */