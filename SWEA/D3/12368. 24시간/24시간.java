import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n + m > 24) System.out.println("#" + i + " " + (n + m - 24));
            else if(n + m < 24) System.out.println("#" + i + " " +(n + m));
            else System.out.println("#" + i + " " +0);
        }
    }
}