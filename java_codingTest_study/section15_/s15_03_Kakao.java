package java_codingTest_study.section15_;
//25 07 01

import java.util.*;
public class s15_03_Kakao {
    public static void main(String[] args) {
        String input1 = "()))((()";
        System.out.println(getCorrectParentheses(input1));  // "()(())()"가 되어야 함

        System.out.println("정답 = (((()))) / 현재 풀이 값 = " + getCorrectParentheses(")()()()("));
        System.out.println("정답 = ()()( / 현재 풀이 값 = " + getCorrectParentheses("))()("));
        System.out.println("정답 = ((((()())))) / 현재 풀이 값 = " + getCorrectParentheses(")()()()(())("));
    }

    public static String getCorrectParentheses(String s) {
        // 여기에 로직 구현
        if(is_it_correct(s)) return s;
        else return change_to_correct(s);


    }
    public static String change_to_correct(String s){
//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(s.length()==0) return "";
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
//            단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.

        else{
            String uv[]=seperate_string(s);
//            3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//            3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            String u = uv[0];
            String v = uv[1];

            if(is_it_correct(u)) return u+change_to_correct(v);
//            4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//            4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.

//            4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//            4-3. ')'를 다시 붙입니다.
//            4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//            4-5. 생성된 문자열을 반환합니다.
            else{
                return "(" + change_to_correct(v) + ")" + reverse(u.substring(1, u.length() - 1));
            }
        }
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(char x:s.toCharArray()){
            sb.append(x == '(' ? ')' : '(');
        }
        return sb.toString();
    }

    public static String[] seperate_string(String s){
        int right_parentheses=0, left_parentheses=0;
        String[] arr = new String[2];
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        Queue<Character> q = new ArrayDeque<>();
        for(char x:s.toCharArray()) q.add(x);

        while(!q.isEmpty()){
            char x = q.poll();
            u.append(x);

            if(x=='(') left_parentheses++;
            else if(x==')') right_parentheses++;

            if (right_parentheses ==  left_parentheses) break;
        }
        for(char x:q) v.append(x);

        arr[0]=u.toString();arr[1]=v.toString();
        return arr;

    }




    public static boolean is_it_correct(String s){
        Stack<Character> stack = new Stack<>();
        for(char x:s.toCharArray()){
            if(x=='('){
                stack.push('(');
            }else if( x==')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
/*
(())()
)()
)
()



(()))(
(())()

 */