import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            int j = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            if(l > k) System.out.println("#" + i + " " + (-1));
            else if(l < j) System.out.println("#" + i + " "+ (j - l));
            else System.out.println("#" + i + " "+ 0);
        }
    }
}