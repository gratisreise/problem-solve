import java.util.*;


public class Main {
    static List<String> ret = new ArrayList<>();
    static String num = "";

    public static void go() {
        // 0없애주는 포맷팅
        while (!num.isEmpty() && num.charAt(0) == '0') {
            num = num.substring(1);
        }
        // 0밖에 없으면 0추가
        if (num.isEmpty()) {
            num = "0";
        }
        //ret list에 추가
        ret.add(num);
        //다시 빈칸으로 초기화
        num = "";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (char c : s.toCharArray()) {
                //숫자면 num에 추가
                if ('0' <= c && c <= '9') num += c;
                // 숫자가 아니면 숫자 포매팅
                else if (!num.isEmpty()) go();
            }
            // 문자열 끝났을 때 처리
            if (!num.isEmpty()) go();
        }

        // 오름차순 커스텀 개조
        Collections.sort(ret, (a, b) -> {
            //길이가 같을 때 오름차순 정렬
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            //길이가 짧은 문자열이 앞에 오도록
            return Integer.compare(a.length(), b.length());
        });

        for (String ss : ret) System.out.println(ss);
    }
}
