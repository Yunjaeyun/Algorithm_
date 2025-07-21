package java_codingTest_study.section15_;
//250713
import java.util.*;
public class s15_09_Kakao_2 {



    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String m = sc.next();
        String[] musicinfos=new String[2];
        for(int i=0;i<2;i++){
            musicinfos[i] = sc.next();
        }


        System.out.println(solution(m, musicinfos));


    }



    private static class Info{
        String name; int playtime,order;

        public Info(String name, int playtime, int order) {
            this.name = name;
            this.playtime = playtime;
            this.order = order;
        }
    }
    public static String solution(String m, String[] musicinfos){
        List<Info> answer=new ArrayList<>();

        int order=0;
        // Info(곡제목,플레이시간)


        m = norm(m);
        for(String musicinfo:musicinfos){

            String[] info = musicinfo.split(",");
            String start_time = info[0];
            String end_time = info[1];
            String name = info[2];
            String melody = info[3];
            melody = norm(melody);

            int play_time=
                    (Integer.parseInt(end_time .substring(0,2))*60 + Integer.parseInt(end_time.substring(3,5)))
                    -(Integer.parseInt(start_time .substring(0,2))*60 +Integer.parseInt(start_time.substring(3,5)));

            //시간초에 맞게 반복하도록 늘려서 -> 일치하는지 확인.

            //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
            // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.

            StringBuilder sb = new StringBuilder();
            int len = melody.length();
            for(int i=0;i<play_time;i++){
                sb.append(melody.charAt(i % len));
            }



            if(sb.toString().contains(m)){
                answer.add(new Info(name, play_time,order));

            }
            order++;



        }

        // 재생시간이 긴순으로 정렬
        answer.sort((a, b) -> {
            if(a.playtime!=b.playtime) return b.playtime-a.playtime;
            return a.order-b.order;
        });

        if(answer.size()==0) return "(None)";
        else return answer.get(0).name;



    }

    public static String norm(String s){
        return s.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f").replace("G#", "g").replace("A#", "a")
                .replace("B#","B");
    }
}
