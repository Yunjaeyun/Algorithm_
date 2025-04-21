package java_codingTest_study.section5_해시;
import java.util.*;
import java.lang.*;
//25 01 30
/*

{'A':0}

BACBACCACCBDEDE

 */
public class s5_01_해시 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        String vote = sc.next();

        System.out.println(check(vote));
    }
    private static Character check(String vote_papers){
        Map<Character, Integer> vote_ing = new HashMap<>();
        int len= vote_papers.length();

        for(int i=0; i<len;i++){

            char x = vote_papers.charAt(i);  //'B'

            if(vote_ing.containsKey(x)){ //Java는 꺼내서 다시 넣어야함.
//                vote_ing[x]+=1 느낌

//                int cur_vote = vote_ing.get(x);
//                cur_vote= cur_vote+1
//                vote_ing.put(x, cur_vote);

                vote_ing.put(x, vote_ing.get(x)+ 1);
            }else{
                vote_ing.put(x,0);
            }
        }
        // 역정렬 Map -> List
        List<Map.Entry<Character, Integer>> reversed_vote_result = new ArrayList<>(vote_ing.entrySet());
        //{'A':100, 'B':200}
        reversed_vote_result.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        return reversed_vote_result.get(0).getKey();



    }
}
