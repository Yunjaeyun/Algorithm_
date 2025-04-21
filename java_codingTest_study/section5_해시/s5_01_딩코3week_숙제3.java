package java_codingTest_study.section5_해시;
//25 01 27
import java.util.*;
import java.lang.*;

/* 0          1      2          3          4
["classic", "pop", "classic", "classic", "pop"]
[500,         600,     150,       800,    2500]

0
{"classic":500}
{"classic":((0,500))}

1
{"classic":500,"pop":600}
{"classic":((0,500)),"pop":((1,600))}

2
{"classic":650,"pop":600}
{"classic":((0,500),(2,150),"pop":((1,600))}

3
{"classic":1450,"pop":600}
{"classic":((0,500),(2,150),"pop":((1,600),(3,800))}

4
{"classic":1450,"pop":3100}
{"classic":((0,500),(2,150),"pop":((1,600),(3,800),(4,2500)}

****
{"pop":3100,"classic":1450}

 */
public class s5_01_딩코3week_숙제3 {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer ;

//        genres[0]=plays[0]
        int len=genres.length;
        HashMap<String, Integer> genre_order = new HashMap<>();
        Map<String, List<int[]>> genre_in_play_order = new HashMap<>();
        for(int i=0; i<len;i++){

            String genre=genres[i]; //classic
            int play=plays[i]; //500

            // 기존에 있다면 case, 없다면 case
            if(genre_order.containsKey(genre)){
//                int cur_play = genre_order.get(genre);
//                int update_play=cur_play+play;
//                genre_order.put(genre, update_play);
                genre_order.put(genre, genre_order.get(genre)+play);
                genre_in_play_order.get(genre).add(new int[]{i,play});

            } else {
                genre_order.put(genre, play);

                List<int[]> newList=new ArrayList<>();
                newList.add(new int[]{i,play});
                genre_in_play_order.put(genre,newList);
            }

        }
        // 첫째 dict를 장르순으로 역정렬 왜? hashmap은 정렬기능이 없으므로 정렬기능있는 list로.
        List<Map.Entry<String,Integer>> tmp = new ArrayList<>(genre_order.entrySet());
        tmp.sort((a,b)->b.getValue().compareTo(a.getValue()));

//        Map<String, Integer> sorted_genre_order = new LinkedHashMap<>();

        List<Integer> bestAlbum = new ArrayList<>();

        for(Map.Entry<String,Integer> entry:tmp){ //{"classic":((0,500),(2,150),"pop":((1,600),(3,800))}
            String genre=entry.getKey();
            List<int[]> arr = genre_in_play_order.get(genre);

            arr.sort((x, y) -> y[1] - x[1]);

            for(int i=0; i<2&& i<arr.size();i++){
                 bestAlbum.add(arr.get(i)[0]);
            }
        }
        answer=new int[bestAlbum.size()];
        for(int i=0; i<bestAlbum.size();i++){
            answer[i]=bestAlbum.get(i);
        }
//        System.out.println(sorted_genre_order);   {"pop":3100,"classic":1450}

        return answer;
    }


    public static void main(String[]args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result=(solution(genres, plays));
        System.out.println(Arrays.toString(result)); //*
    }
}
