import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        boolean hasUpper = false;
        boolean hasUnder = false;
        boolean isError = false;

        // 1. 기본 에러 체크: 첫 글자 대문자 또는 _ / 마지막 글자 _
        if (s.charAt(0) == '_' || Character.isUpperCase(s.charAt(0)) || s.charAt(s.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) hasUpper = true;
            if (c == '_') {
                hasUnder = true;
                // 2. 연속된 언더바 체크
                if (i > 0 && s.charAt(i - 1) == '_') isError = true;
            }
        }

        // 3. 대문자와 언더바가 혼용된 경우 에러
        if (isError || (hasUpper && hasUnder)) {
            System.out.println("Error!");
            return;
        }

        // 변환 로직
        if (hasUnder) { // C++ to Java
            StringBuilder sb = new StringBuilder();
            boolean nextUpper = false;
            for (char c : s.toCharArray()) {
                if (c == '_') {
                    nextUpper = true;
                } else {
                    if (nextUpper) {
                        sb.append(Character.toUpperCase(c));
                        nextUpper = false;
                    } else {
                        sb.append(c);
                    }
                }
            }
            System.out.println(sb.toString());
        } else if (hasUpper) { // Java to C++
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        } else { // 둘 다 아닌 경우 (전부 소문자)
            System.out.println(s);
        }
    }
}