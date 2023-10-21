import java.util.*;

public class Main{
    public static int operator(int a, int b){
        return (a + b) * (a - b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt();
        System.out.println(operator(a, b));
    }
}
