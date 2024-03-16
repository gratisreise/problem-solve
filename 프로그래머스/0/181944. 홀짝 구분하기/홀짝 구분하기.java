import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ret = "";
        if(n % 2 == 0) ret += n + " is even";
        else ret += n + " is odd";
        System.out.println(ret);
    }
}