import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 4];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == v) cnt++;
        }
        System.out.println(cnt);
    }
}
