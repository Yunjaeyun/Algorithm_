package java_codingTest_study.section5_해시.section5_R2;
//25 04 11
/*
classic pop classic classic pop
 500    600 150     800     2500
0       3   1       2       4

고유번호i라는걸 계속 지니고있어야함.
HashMap
{"classic":(), "pop":()}

classic  pop
1450     3100




 */

import java.util.*;

class Info implements Comparable<Info>{
    int x,play;
    Info(int x, int play){
        this.x=x;
        this.play=play;
    }
    @Override
    public int compareTo(Info other){
        if(other.play==this.play) return this.x-other.x;
        else return other.play - this.play;
    }
}
public class s5_06_dingo {
    public static void main(String[]args){
        String[]genres={"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(sol(genres, plays)));

    }

    public static int[]sol(String[] genres,int[] plays ){
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, List<Info>> map2 = new HashMap<>();
        for(int i=0;i<genres.length;i++){

            String genre = genres[i]; //"classic" "classic"
            int play = plays[i];      // 500       300


            // genre가 ㅣ이미 있으면
            // 추가 [i, play]저장 {classic:[(0,500),(1,200)]
            if(map2.containsKey(genre)){
//                map1.put(genre, play); <-  x Map은 (a,b) 같은거 잇을때 ***갯수***를 +count 해주는것일뿐.
                int value = map1.get(genre) + play;
                map1.put(genre, value);

                map2.get(genre).add(new Info(i,play));
            }

            //genre가 없으면
            // 새로 만들기 []
            else{
                map1.put(genre, play);

                List<Info> arr = new ArrayList<>();
                arr.add(new Info(i, play));
                map2.put(genre, arr);
            }

        }
        List<Map.Entry<String, Integer>> tmp = new ArrayList<>(map1.entrySet()); //*******  ["x":500, "y":200]
        tmp.sort((a, b) -> b.getValue() - a.getValue());  // a=> "x":500        b=>"y":200

        List<Integer> bestAlbum=new ArrayList<>() ;

        for(Map.Entry<String,Integer> entry: tmp){  //classic   pop
            String cur_genre = entry.getKey();

            List<Info> arr = map2.get(cur_genre); //[(2,200),(0,100)]
            arr.sort(null);  //********

            //temp에 두개씩 추가
            for(int i=0;i<2;i++){
                bestAlbum.add(arr.get(i).x);
            }
        }

        int[] result = new int[bestAlbum.size()];
        for(int i=0;i<bestAlbum.size();i++){
            result[i] = bestAlbum.get(i);
        }


        return result;
    }
}
