import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) { // 대문자이면
                if (c + 13 > 'Z') {
                    c = (char) (c - 13);
                } else {
                    c = (char) (c + 13);
                }
            } else if (Character.isLowerCase(c)) { // 소문자이면
                if (c + 13 > 'z') { //범위 벗어나면 -13
                    c = (char) (c - 13);
                } else { // 범위 안 벗어나면 그냥 +13
                    c = (char) (c + 13);
                }
            }
            // 바뀐 문자 ret객체에 투입
            ret.append(c);
        }

        System.out.println(ret);
    }
}
