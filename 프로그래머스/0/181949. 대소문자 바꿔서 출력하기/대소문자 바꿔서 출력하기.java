import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder ret = new StringBuilder();
        for(char c : a.toCharArray()){
            if('a' <= c && c <= 'z') ret.append((char)(c - 'a' + 'A'));
            else if('A' <= c && c <= 'Z') ret.append((char)(c - 'A' + 'a'));
        }
        System.out.println(ret);
    }
}