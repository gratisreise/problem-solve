import java.io.*;
import java.util.*;

public class Main{
    static PriorityQueue<String> ret = new PriorityQueue<>(
            (a1, a2) -> {
                if(a1.length() == a2.length()){
                    return a1.compareTo(a2);
                }
                return Integer.compare(a1.length(), a2.length());
            }
    );

    static void deleteZero(StringBuilder sb){
        while(sb.length()> 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        ret.add(sb.toString());
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n-- > 0){
            String s = br.readLine();
            StringBuilder temp = new StringBuilder("");
            for(char c : s.toCharArray()){
                if('0' <= c && c <= '9') temp.append(c);
                else if(temp.length() > 0) {
                    deleteZero(temp);
                    temp = new StringBuilder("");
                }
            }
            if(temp.length() > 0) deleteZero(temp);
        }

        while(!ret.isEmpty()) bw.write(ret.poll() + '\n');
        bw.flush();
    }
}
/*
숫자 + 소문자 -> 숫자 찾아서 오름차순 정렬 숫자앞 0은 생략해줌
100글자 -> int, long 불가 -> 문자열로 저장하고 대소비교
앞의 0이있으면

1.테스트케이스의 갯수 n 입력받기
2. 문자열을 입력받는다.
3. 문자열을 순회한다.
    3-1. 숫자이면 temp문자열에 저장
    3-2. 숫자가 아닐때
        3-2-1. temp가 있으면 0제거 메서드 실행하고 리스트 저장
        3-2-2. temp가 없으면 다음으로
4. 문자열 순회 완료 후 temp 있으면 0제거 메서드 실행하고 리스트 저장
5. 리스트 문자열기준 오름차순 정렬 compareTo메서드 활용
 */