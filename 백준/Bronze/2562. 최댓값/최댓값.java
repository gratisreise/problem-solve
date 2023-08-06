import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n; int idx = 0; int mx = 0;
        for(int i = 1; i <= 9; i++){
            n = sc.nextInt();
            if(n > mx){
                mx = n; idx = i;
            }
        }
        System.out.println(mx);
        System.out.println(idx);
    }
}