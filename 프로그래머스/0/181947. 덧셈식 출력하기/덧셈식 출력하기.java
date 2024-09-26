import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder ret = new StringBuilder();
        ret.append(String.valueOf(a));
        ret.append(" + ");
        ret.append(String.valueOf(b));
        ret.append(" = ");
        ret.append(String.valueOf(a + b));
        System.out.println(ret);
    }
}