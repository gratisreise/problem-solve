import java.util.*;
public class Main{
    static int[] a = new int[9];
    static int b, c;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < 9; i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < i; j++){
                if(sum - a[i] - a[j] == 100){
                    b = a[i]; c = a[j];
                }
            }
        }
        Arrays.sort(a);
        for(int i = 0; i < 9; i++){
            if(a[i] == b || a[i] == c) continue;
            System.out.println(a[i]);
        }
    }

}