package java_codingTest_study.section12_etc_graph;
//25 04 22 1250

import java.util.*;
public class s12_03_2583 {
    static char arr[];
    static int l,c; //4 6

    static int []visited;

    static char pm[];

    static TreeSet<String> ts = new TreeSet<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         l = sc.nextInt();
         c = sc.nextInt();

        arr = new char[c];
        pm = new char[l];
        visited = new int[c];

        for(int i=0;i<c;i++){
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        DFS(0,0);
    }
    private static void DFS(int L, int s){ //level, start
        if(L==l){ //pm
            if(validate(pm)){
                for(char x:pm) System.out.print(x);
                System.out.println();
            }

        }else{
            for(int i=s;i<c;i++){
                pm[L] = arr[i];
                DFS(L + 1, i+1);
            }
        }
    }
    private static boolean validate(char[] pm){
        int vowelCount=0; //모음  aeiou
        int consotantCount=0;


        for(char x:pm){
            if(isvowel(x)) vowelCount++;
            else consotantCount++;
        }

        if(vowelCount>=1 && consotantCount>=2) return true;
        else return false;
    }
    private static boolean isvowel(char c){
        if(c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u') return true;
        else return false;
    }


}

/*
0 1 2 3 4 5

0123
0124
0125

0134
0135

arr'atcisw'
[xxxx] result

 result[0] = arr[0]
 result[1] = arr[1]
 result[2] = arr[2]
 result[3] = arr[4]

=======  ========


            0
          /0|1|2|3|4\5
          1
       /0|1|2|3|4\5
          2
      /0|1|2|3|4\5
     3
   /0|1|2|3|4\5
  4


d(3) for arr[i] i=5
d(2) for arr i=0
d(1)
d(0)
 */