import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 1;
        for(int i = 0; i < n; i++){
            ret *= (i + 1);
        }
        System.out.println(ret);
    }
}