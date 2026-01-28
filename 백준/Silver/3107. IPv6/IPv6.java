import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // 1. "::"를 처리하기 쉽게 ":db:"로 변경
        // ::가 있는 위치에 필요한 만큼의 0000 그룹을 넣기 위함입니다.
        if (input.contains("::")) {
            input = input.replace("::", ":db:");
        }

        // 2. ":"를 기준으로 분리
        String[] splitInput = input.split(":");
        List<String> groups = new ArrayList<>();

        // 3. 실제 값이 있는 그룹의 개수 파악 (db 제외)
        int actualGroupCount = 0;
        for (String s : splitInput) {
            if (!s.isEmpty() && !s.equals("db")) {
                actualGroupCount++;
            }
        }

        // 4. 복원 로직 진행
        for (String s : splitInput) {
            if (s.isEmpty()) continue; // 맨 앞이나 뒤의 빈 공간 무시

            if (s.equals("db")) {
                // 생략된 그룹의 수만큼 0000 추가
                int missingCount = 8 - actualGroupCount;
                for (int i = 0; i < missingCount; i++) {
                    groups.add("0000");
                }
            } else {
                // 4자리가 되도록 앞에 0 추가
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4 - s.length(); i++) {
                    sb.append('0');
                }
                sb.append(s);
                groups.add(sb.toString());
            }
        }

        // 5. 결과 출력 (각 그룹을 :로 연결)
        System.out.println(String.join(":", groups));
        sc.close();
    }
}