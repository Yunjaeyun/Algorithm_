package java_codingTest_study.section13_simul;
//250607
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s13_04_14890 {

    static int board[][];
    static int n,L;
    static int answer=0;


    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for(int i=0;i<n;i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        func( board);
    }
    private static void func(int board[][]) {

        /*
        { 1 ,2},
        {     },
        {     }
         */


        // 행 검사 ---


        for(int i=0;i<n;i++){
            // 한줄 읽기
            int[] row = board[i];

            // 검사

            if(check(row)) answer++;

        }

        //열 검사 |
        /*
          {3      }, (0,  0)
          {3      }, (1,  0)
          {2      }, (2,  0)
          {4      }  (3,  0)
                     변화 고정

         */
        for(int j=0;j<n;j++){
            int[] col = new int[n];

            for(int i=0;i<n;i++){
                col[i] = board[i][j];
            }

            if(check(col)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean check(int [] line){
        boolean used[] = new boolean[n];

        for(int i=0;i< n-1;i++){

            if(line[i]==line[i+1]) continue;

            //그 순간부터 연속된 길이 count
                // arr[x] == arr[x+1] ok
                // arr[x] < arr[x+1] -> 1.격차1      2. 연속된길이count는 L은 넘어야함. 그래야 경사로놓지.
                // arr[x] > arr[x+1] ->

            //오르막길
                // 0. 높이 차이 1인가( 이미검사)
                // 1. 겹치지않는가
                // 2. 경사로를 둘 L칸이 다 같은높이인가
                // 3. 범위를 벗어나진 않는가

            /*                      <
                i-2    i-1     i       i+1
                       경사로   경사로
                       i-1     i-0

             */
            if(line[i]+1==line[i+1]){
                for(int j=0;j<L;j++){
                    int idx=i-j;

                    if(idx<0 || line[idx]!=line[i]|| used[idx]) return false ;
                    used[idx] = true; //경사로 설치
                }
            }

            //내리막길
                // 0. 높이 차이 1인가( 이미검사)
                // 1. 겹치지않는가
                // 2. 경사로를 둘 L칸이 다 같은높이인가
                // 3. 범위를 벗어나진 않는가
            /*
            L=2
                                     >
                i-2     i-1     i         i+1  ... i+2
                                         경사로    경사로
                                          i+1     i+L

                1 2 3 4 ..  n-1  n
                             i   i+1

             */
            else if(line[i]-1==line[i+1]){
                for(int j=1;j<=L;j++){ //j=1부터인 이유-> 문제 내리막길 사진보셈 i+1부터 경사로둠
                    int idx = i + j;

                    if(idx>=n||used[idx]|| line[i+1]!=line[idx]) return false;
                    used[idx] = true;
                }

            }
            else return false;
        }
        return true;
    }



}
