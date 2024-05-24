import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String stringAdd(String a, String b) {
        int sum = 0;
        StringBuilder ret = new StringBuilder();

        // 1의 자리부터
        int i = a.length() - 1;
        int j = b.length() - 1;

        // a, b 문자열의 끝부터 숫자를 더하기
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            ret.append(sum % 10);
            sum /= 10;
        }

        // 결과 문자열을 뒤집어서 반환
        return ret.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        // 빠른 입력과 출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 두 개의 문자열 입력받기
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        // 문자열 덧셈 수행
        String result = stringAdd(a, b);

        // 결과 출력
        bw.write(result + "\n");
        bw.flush();
    }

}