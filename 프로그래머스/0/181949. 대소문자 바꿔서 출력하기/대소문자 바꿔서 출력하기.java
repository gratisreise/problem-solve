import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String ret = "";
        for(char c : a.toCharArray()){
            if('a' <= c && c <= 'z'){
                ret += (char)(c - 32);
            } else if('A' <= c && c <= 'Z'){
                ret += (char)(c + 32);
            }
        }
        System.out.println(ret);
    }
}