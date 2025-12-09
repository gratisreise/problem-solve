import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        // K: 수강 가능 인원, L: 대기 목록 길이 (클릭 횟수)
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // LinkedHashSet: 삽입 순서를 유지하며 중복을 허용하지 않음
        // 학번은 8자리 문자열이므로 String으로 처리
        LinkedHashSet<String> waitingList = new LinkedHashSet<>();

        for(int i = 0; i < l; i++){
            // 학번을 String으로 입력받음
            String studentId = in.readLine();

            // 이미 대기열에 있으면: 기존 요소를 삭제하고 (맨 앞에서 밀려남)
            if(waitingList.contains(studentId)){
                waitingList.remove(studentId);
            }

            // 요소를 맨 뒤에 추가 (대기열 맨 뒤로 밀려남)
            waitingList.add(studentId);
        }

        // 최종 대기열을 List로 변환하여 K명까지만 출력
        int count = 0;
        for(String studentId : waitingList){
            if(count >= k){
                break;
            }
            out.println(studentId);
            count++;
        }

        out.flush();
        out.close();
    }
}