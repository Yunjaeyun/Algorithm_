package java_codingTest_study.section15_;

import java.util.ArrayList;
import java.util.List;

//250713
public class s15_10_Kakao_3 {
    public static void main(String[]args){
        String lines[] = new String[2];

        System.out.println(solution(lines));
    }

    private static class Log{
        long start, end;

        public Log(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    static List<Log> list = new ArrayList<>();

    private static int solution(String[] lines){
//"2016-09-15 01:00:04.001 2.0s"
        for(String s:lines){
            String[] cur = s.split(" ");
            String endtime = cur[1];
            String duration = cur[2];

            // 0.351s
            double Duration = Double.parseDouble(duration.replace("s", ""));
            long durationTime =(long) (Duration*1000);

            String[] e = endtime.split(":"); //20:59:57.421 0.351s
            long hour = Long.parseLong(e[0]);
            long min = Long.parseLong(e[1]);
            String sec = e[2]; //57.421

            String[] split = sec.split("\\.");

            long second = Long.parseLong(split[0]);
            long millsec = Long.parseLong(split[1]);




            long end_time=(hour*3600 + min*60 +second)*1000 + millsec;

            long starttime= end_time
                    -durationTime +1;

            list.add(new Log(starttime, end_time));




        }

        int answer=0;
        for(Log cur:list){

            answer=Math.max(answer,check(cur.start, list));
            answer=Math.max(answer,check(cur.end, list));
        }
        return answer;
    }

    private static int check(long startTime, List<Log> list){
        int cnt=0;

        long endtime=startTime+1000;

        for(Log log:list){
            // 해당 로그 값이 start< < end 라면 +1
            if(startTime<=log.end && log.start<endtime ){
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1초 = 1000ms
1분 =60초 = 1초 *60
1시간 = 60분 = 3600초 = 1초 * 3600



 */