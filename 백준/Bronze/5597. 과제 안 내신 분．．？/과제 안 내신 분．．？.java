import java.util.Scanner;

public class Main {
    public static int[] cnt = new int[34];
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 28; i++){
            int temp = sc.nextInt();
            cnt[temp] = 1;    
        }
        for(int i = 1; i <= 30; i++){
            if(cnt[i] == 0){
                System.out.println(i);
            }
        }
    }
}