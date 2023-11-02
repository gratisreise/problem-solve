import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();
        int r, l = 1, ret = 0;

        for(int i = 0; i < j; i++){
            r = l + m - 1; 
            int temp = sc.nextInt();
            if(l <= temp && temp <= r) continue;
            if(temp < l){
                ret += l - temp;
                l = temp;
            } else {
                ret += temp - r;
                l += temp - r;
            }
        }
        System.out.println(ret);
    }
}