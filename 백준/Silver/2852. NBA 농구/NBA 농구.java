import java.util.Scanner;

public class Main {
    static String print(int sum) {
        int hours = sum / 60;
        int minutes = sum % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    static int change(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = 0, B = 0;
        int asum = 0, bsum = 0;
        String T, prev = "00:00";

        for (int i = 0; i < n; i++) {
            int tnum = sc.nextInt();
            T = sc.next();

            if (A > B) asum += change(T) - change(prev);
            if (B > A) bsum += change(T) - change(prev);
            if (tnum == 1) {
                A++;
            } else {
                B++;
            }
            prev = T;
        }

        if (A > B) asum += change("48:00") - change(prev);
        if (B > A) bsum += change("48:00") - change(prev);

        System.out.println(print(asum));
        System.out.println(print(bsum));
    }   
}
