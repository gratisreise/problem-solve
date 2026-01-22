import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 T
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            // 하루에 제공되는 사료의 총량 N
            long N = Long.parseLong(br.readLine());
            
            // 첫날 돼지들이 먹는 양의 총합 계산
            long totalEat = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                totalEat += Integer.parseInt(st.nextToken());
            }
            
            int day = 1;
            // 사료의 총합이 준비된 양 N을 넘을 때까지 4배씩 증가
            while (totalEat <= N) {
                totalEat *= 4;
                day++;
            }
            
            System.out.println(day);
        }
    }
}