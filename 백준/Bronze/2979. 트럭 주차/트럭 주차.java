import java.util.*;

public class Main{
    public static int cnt[] = new int[104];
    public static int ret;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        for(int i = 0; i < 3; i++){
            int a = sc.nextInt(); int b = sc.nextInt();
            for(int j = a ; j < b; j++){
                cnt[j]++;
            }
        }

        for(int i = 0; i < 100; i++){
            if(cnt[i] == 1) ret += A;
            else if(cnt[i] == 2) ret += B * 2;
            else if(cnt[i] == 3) ret += C * 3;
        }

        System.out.println(ret);
    }
}
