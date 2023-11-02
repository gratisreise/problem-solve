import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int ret2 = 0, ret5 = 0;
            int n = sc.nextInt();

            for(int j = 5; j <= n; j *= 5){
                ret5 += n / j;
            }
            for(int j = 2; j <= n; j *= 2){
                ret2 += n / j;
            }
            
            System.out.println(Math.min(ret2, ret5));
        }
    }
}