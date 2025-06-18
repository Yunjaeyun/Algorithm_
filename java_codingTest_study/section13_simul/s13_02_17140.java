package java_codingTest_study.section13_simul;
//250602

import java.util.*;
public class s13_02_17140 {

    static List<List<Integer>> board=new ArrayList<>();
    /*

    {     },
    {     },
    {     }

     */

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt()-1;
        int c = sc.nextInt() - 1;

        int k = sc.nextInt();

        for(int i=0;i<3;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<3;j++){
                row.add(sc.nextInt());
            }
            board.add(row);
        }

        System.out.print(extracted(r, c, k));


        //만약 100초가 지나도 board[r][c]=k가 되지않으면 -1


    }

    private static int extracted(int r, int c, int k) {
        int minute=0;

        //만약 100초 이내 board[r][c]=k 라면 return minute
        // 행row 갯수 >= 열col 갯수 -> r연산
        //모든 행에 대한 정렬==
        // dict={:} 그리고 0채울것
        for(minute=0;minute<=100;minute++){
            if(r< board.size()&& c<board.get(0).size() && board.get(r).get(c)== k) return minute;

            int rowCount = board.size();
            int colCount = board.get(0).size();

            if(rowCount>=colCount){
                /*
                arr[0] -> {3,1,1}
                arr[1] -> {1,3,1}
                arr[2] -> {2,2,4}               */

                List<List<Integer>> newBoard = new ArrayList<>();
                int maxRowLen=0;

                for(int i=0;i<rowCount;i++){
                    List<Integer> temp_arr = board.get(i); // 3, 1, 1 ?

                    Map<Integer, Integer> map = new HashMap<>();

                    for(int x:temp_arr){
                        if (x == 0) continue;
                        map.put(x, map.getOrDefault(x, 0) + 1); // -> (3,1 1,2) 숫자, 등장횟수
                    }

                    // 정렬 1. 수의 등장횟수, 2. 수가 커지는 순
                    // 값 저장은 어디에? -> 이중 배열 갈아끼우기 board.set
                    //  행 또는 열의 크기가 커진 곳에는 0이 채워진다. 수를 정렬할 때 0은 무시
                    // 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
                    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
                    list.sort((a,b)->{
                        if(a.getValue().equals(b.getValue())){
                            return a.getKey() - b.getKey();
                        }
                        return a.getValue() - b.getValue();
                    });

                    List<Integer> temp = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> entry : list) {
                        temp.add(entry.getKey());
                        temp.add(entry.getValue());
                    }
                    // -> temp : (3,1 1,2) 다시 for문 돌려서 최대 길이

                    maxRowLen = Math.max(maxRowLen, temp.size());
                    newBoard.add(temp);


                }
                maxRowLen = Math.min(maxRowLen, 100); // limit 100으로.
                // 늘리고 ,혼자 100 초과된 부분은 잘라내기
                for(List<Integer> row:newBoard){
                    while(row.size()<maxRowLen) row.add(0);
                    while(row.size()>maxRowLen) row.remove(row.size() - 1);
                }

                board=newBoard;



                // else 행의 갯수<열 갯수
                //모든 열에 대한 정렬 |

                /*
                모든 열col에 대한 정렬
                 */

            }else if(rowCount<colCount){

                int maxColLen=0;
                List<List<Integer>> newBoard = new ArrayList<>();

                for(int i=0;i<colCount;i++){
                    Map<Integer, Integer> col_map = new HashMap<>();

                    for(int j=0;j<rowCount;j++) {
                        int x = board.get(j).get(i);    // 각 행의 x번째

                        /*
                        arr[0] -> {3,1,1}
                        arr[1] -> {1,3,1}
                        arr[2] -> {2,2,4}
                         */

                        if (x == 0) continue;
                        col_map.put(x, col_map.getOrDefault(x, 0) + 1);
                    }
                    // 정렬
                    List<Map.Entry<Integer, Integer>> arr = new ArrayList<>(col_map.entrySet());
                    arr.sort((a, b) -> { //a(수 ,등장횟수 ) b( , )
                        if (a.getValue().equals(b.getValue())) {
                            return a.getKey() - b.getKey();
                        }
                        return a.getValue() - b.getValue();
                    }); // (1 1) (2 1) (3 1)

                    //맵리스트에서 온전한 리스트로 변환
                    List<Integer> temp_col = new ArrayList<>();
                    for(Map.Entry<Integer,Integer> ar:arr){
                        temp_col.add(ar.getKey());
                        temp_col.add(ar.getValue());
                    }

                    // 0추가 / 100 limit
                    maxColLen = Math.max(maxColLen, temp_col.size());
                    newBoard.add(temp_col);


                    // 100 컷

                }

                maxColLen = Math.min(maxColLen, 100);

                for(List<Integer> col:newBoard){
                    while(col.size()<maxColLen) col.add(0);
                    while(col.size()>maxColLen) col.remove(col.size() - 1);
                }
                // 행 단위로 재구성 x번째 행의 y번째 열
                // newBoard의
                // for 행
                //    for 열
                /*

                    {3,1,1}
                    {1,3,1}
                    열 열 열





                 */

                // [3] 행 단위로 재구성 행이 바뀌면서 열은 고정-> 고정되어있어야 하는게 밖for 열 문
                List<List<Integer>> rotated = new ArrayList<>();
                for(int i=0;i<maxColLen;i++){
                    List<Integer> newRow = new ArrayList<>();
                    for(int j=0;j<newBoard.size();j++){
                        newRow.add(newBoard.get(j).get(i));
                    }
                    rotated.add(newRow);
                }
                board = rotated;



            }

        }
        return -1;
    }
}
