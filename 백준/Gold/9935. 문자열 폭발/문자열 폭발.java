import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String str = in.readLine();
        String bomb = in.readLine();
        int strLen = str.length();
        int bombLen = bomb.length();

        // char 배열을 스택처럼 사용 (손가락 보호 + 성능 최강)
        char[] result = new char[strLen];
        int size = 0;

        for (int i = 0; i < strLen; i++) {
            result[size++] = str.charAt(i); // 일단 넣는다!

            // 스택에 쌓인 글자가 폭발 문자열보다 길면 검사 시작
            if (size >= bombLen) {
                boolean isBomb = true;
                for (int j = 0; j < bombLen; j++) {
                    // 뒤에서부터 비교
                    if (result[size - bombLen + j] != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    size -= bombLen; // 폭발! 포인터만 뒤로 밀면 끝 (O(1))
                }
            }
        }

        if (size == 0) {
            out.println("FRULA");
        } else {
            // 남은 만큼만 빌더에 담기
            var sb = new StringBuilder();
            for (int i = 0; i < size; i++) sb.append(result[i]);
            out.println(sb);
        }

        out.flush();
        out.close();
    }
}