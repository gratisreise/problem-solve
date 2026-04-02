import java.io.*;
import java.util.*;

public class Main {
    // 앞의 0을 제거하는 메서드 (학생의 cut과 로직은 비슷하지만 더 간결하게!)
    static String cleanZero(String s) {
        int idx = 0;
        // 0이 아닌 숫자가 나올 때까지 인덱스 이동
        while(idx < s.length() - 1 && s.charAt(idx) == '0'){
            idx++;
        }
        return s.substring(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                if(Character.isDigit(c)){
                    sb.append(c);
                } else {
                    if(sb.length() > 0){
                        list.add(cleanZero(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            //끝처리
            if(sb.length() > 0) list.add(cleanZero(sb.toString()));
        }

        list.sort((a, b) ->{
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        // 결과 출력
        for (String s : list) out.println(s);
        
        out.flush();
        out.close();
    }
}