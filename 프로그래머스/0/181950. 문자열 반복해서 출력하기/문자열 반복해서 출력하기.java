import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String ret = "";
        while(n-- > 0){
            ret += str;
        }
        System.out.println(ret);
    }
}