import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < n; i++) ret.append(str);
        System.out.println(ret);
    }
}